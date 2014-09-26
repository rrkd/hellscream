package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.AddressVO;
import au.com.iglooit.hellscream.model.vo.MerchantSearchResult;
import au.com.iglooit.hellscream.model.vo.MerchantVO;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.repository.BaseRepository;
import au.com.iglooit.hellscream.service.IndexServiceHelp;
import au.com.iglooit.hellscream.service.search.GeoSearchService;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.search.Document;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.PutException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:55 AM
 */
@Repository
@Transactional
public class MerchantDAOImpl extends BaseRepository<Merchant> implements MerchantDAO {
    private static final Logger LOG = LoggerFactory.getLogger(MerchantDAOImpl.class);
    private static final Integer PAGE_COUNT = 10;
    @Resource
    private GeoSearchService geoSearchService;
    @Resource
    private IndexServiceHelp indexServiceHelp;


    public MerchantDAOImpl() {
        super(Merchant.class);
    }

    @Override
    public List<Merchant> findAllMerchants() {
        List<Merchant> result = findAll();
        LOG.info("size:" + result.size());
        return result;
    }

    @Override
    public List<Merchant> findMerchants(int pos, int size) {
        Query q = getEntityManager().createQuery("select c from Merchant c ")
                .setFirstResult(pos)
                .setMaxResults(size);
        return q.getResultList();
    }

    @Override
    public Merchant findByTradeName(String tradeName) {
        return findAll().get(0);
    }

    @Override
    public void createMerchant(Merchant merchant) {
        // find the geo point
        AddressVO result = geoSearchService.formatAddress(merchant.convertToAddress());
        if (result != null) {
            merchant.setLatitude(new BigDecimal(result.getGeoPoint().getLatitude()));
            merchant.setLongitude(new BigDecimal(result.getGeoPoint().getLongitude()));
            merchant.setPostcode(result.getPostcode());
            merchant.setSuburb(result.getSuburb());
            merchant.setFormatAddress(result.getFormatAddress());
        }
        add(merchant);
        getEntityManager().flush();
        // get full index
        Index merchantIndex = indexServiceHelp.getMerchantIndex();
        // get geo index
        Index geoIndex = indexServiceHelp.getGeoMerchantIndex();
        try {
            merchantIndex.put(merchant.toFullTextDocument());
        } catch (PutException e) {
            throw new AppX("Can't create document for " + merchant.getKey(), e);
        }

        try {
            geoIndex.put(merchant.toGeoDocument());
        } catch (PutException e) {
            throw new AppX("Can't create document for " + merchant.getKey(), e);
        }


    }

    @Override
    public void modifyMerchant(Merchant merchant) {
        // find the geo point
        AddressVO result = geoSearchService.formatAddress(merchant.convertToAddress());
        if (result != null) {
            merchant.setLatitude(new BigDecimal(result.getGeoPoint().getLatitude()));
            merchant.setLongitude(new BigDecimal(result.getGeoPoint().getLongitude()));
            merchant.setPostcode(result.getPostcode());
            merchant.setSuburb(result.getSuburb());
        }
        update(merchant);
        // get full index
        Index merchantIndex = indexServiceHelp.getMerchantIndex();
        // get geo index
        Index geoIndex = indexServiceHelp.getGeoMerchantIndex();
        try {
            String docId = KeyFactory.keyToString(merchant.getKey());
            List<String> ftKeys = new ArrayList<>();
            ftKeys.add(docId);
            Document ftDocument = merchantIndex.get(docId);
            if (ftDocument != null) {

                merchantIndex.delete(ftKeys);
            }

            Document geoDocument = geoIndex.get(docId);
            if (geoDocument != null) {
                geoIndex.delete(ftKeys);
            }

            merchantIndex.put(merchant.toFullTextDocument());
            geoIndex.put(merchant.toGeoDocument());
        } catch (PutException e) {
            throw new AppX("Can't create document for " + merchant.getKey(), e);
        }
    }

    @Override
    public List<Merchant> findByCategoryName(String categoryName) {
        LOG.info("query merchant by " + categoryName);
        Query q = getEntityManager().createQuery("select c from Merchant c where c.categoryList=:categoryName ")
                .setParameter("categoryName", categoryName);
        return q.getResultList();
    }

    @Override
    public List<Merchant> findByCategoryName(List<String> categoryName) {
        LOG.info("query merchant by " + categoryName);
        StringBuilder queryBuilder = new StringBuilder("select c from Merchant c where ");
        if(categoryName.size() == 1) {
            queryBuilder.append(" c.categoryList=:categoryName0 ");
        } else {
            queryBuilder.append(" c.categoryList=:categoryName0 ");
            for (int i = 1; i < categoryName.size(); i++) {
                queryBuilder.append(" or c.categoryList=:categoryName" + i);
            }
        }
        Query q = getEntityManager().createQuery(queryBuilder.toString());
        for (int i = 0; i < categoryName.size(); i++) {
            q.setParameter("categoryName" + i, categoryName.get(i));
        }

        return q.getResultList();
    }

    @Override
    public Boolean checkExistMerchant(String tradeName, String email) {
        Query q1 = getEntityManager().createQuery("select c from Merchant c " +
                "where c.tradeName=:tradeName")
                .setParameter("tradeName", tradeName);
        Query q2 = getEntityManager().createQuery("select c from Merchant c " +
                "where c.email=:email ")
                .setParameter("email", email);
        return q1.getResultList().size() > 0 || q2.getResultList().size() > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public MerchantSearchResult findMerchants(Integer pageNumber) {
        Integer startPage = pageNumber == null ? 1 : pageNumber;
        Query q = getEntityManager().createQuery("select c from Merchant c order by c.postDate desc")
                .setMaxResults(PAGE_COUNT)
                .setFirstResult((startPage - 1) * PAGE_COUNT);
        Query countQuery = getEntityManager().createQuery("select c from Merchant c order by c.postDate desc");

        MerchantSearchResult result = new MerchantSearchResult();
        WebProperties webProperties = WebProperties.getInstance();
        String driveHost = webProperties.get("driver.host");
        for (Merchant merchant : (List<Merchant>) q.getResultList()) {
            MerchantVO vo = new MerchantVO();
            //change image name
            if (!StringUtils.isBlank(merchant.getImageFileName())) {
                merchant.setImageFileName(driveHost + merchant.getImageFileName());
            }
            vo.setMerchant(merchant);
            result.getMerchantList().add(vo);
        }
        result.setPageNum(startPage);
        result.setTotal(countQuery.getResultList().size() / PAGE_COUNT + 1);
        return result;
    }

    @Override
    public Merchant findByURL(String url) {
        Query q = getEntityManager().createQuery("select c from Merchant c " +
                "where c.canonicalSlugId=:canonicalSlugId")
                .setParameter("canonicalSlugId", url);
        List<Merchant> resultList = q.getResultList();
        return resultList.size() > 0 ? resultList.get(0) : null;
    }
}
