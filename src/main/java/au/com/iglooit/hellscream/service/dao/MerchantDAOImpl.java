package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.AddressVO;
import au.com.iglooit.hellscream.model.vo.MerchantVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.repository.BaseRepository;
import au.com.iglooit.hellscream.service.IndexServiceHelp;
import au.com.iglooit.hellscream.service.search.GeoSearchService;
import au.com.iglooit.hellscream.utils.DateUtils;
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
        Query q = getEntityManager().createQuery("select c from Merchant c where c.tradeName=:tradeName ")
            .setParameter("tradeName", tradeName);
        List<Merchant> result = q.getResultList();
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
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
        merchant.setLastUpdateTime(DateUtils.getNow());
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
        if (categoryName.size() == 1) {
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
    public SearchResultVO<MerchantVO> findMerchants(Integer pageNumber) {
        Integer startPage = pageNumber == null ? 1 : pageNumber;
        Query q = getEntityManager().createQuery("select c from Merchant c order by c.postDate desc")
            .setMaxResults(PAGE_COUNT)
            .setFirstResult((startPage - 1) * PAGE_COUNT);
        Query countQuery = getEntityManager().createQuery("select c from Merchant c order by c.postDate desc");

        SearchResultVO<MerchantVO> resultVO = new SearchResultVO<MerchantVO>();
        WebProperties webProperties = WebProperties.getInstance();
        String driveHost = webProperties.get("driver.host");
        for (Merchant merchant : (List<Merchant>) q.getResultList()) {
            MerchantVO vo = new MerchantVO();
            //change image name
            if (!StringUtils.isBlank(merchant.getImageFileName())) {
                merchant.setImageFileName(driveHost + merchant.getImageFileName());
            }
            vo.setMerchant(merchant);
            resultVO.getVoList().add(vo);
        }
        resultVO.setPageNum(startPage);
        resultVO.setTotal(countQuery.getResultList().size() / PAGE_COUNT + 1);
        return resultVO;
    }

    @Override
    public Merchant findByURL(String canonicalSlugId) {
        Query q = getEntityManager().createQuery("select c from Merchant c " +
            "where c.canonicalSlugId=:canonicalSlugId")
            .setParameter("canonicalSlugId", canonicalSlugId);
        List<Merchant> resultList = q.getResultList();
        return resultList.size() > 0 ? resultList.get(0) : null;
    }

    @Override
    public SearchResultVO<MerchantVO> findMerchants(String prefix, Integer pageNumber) {
        assert StringUtils.isNotBlank(prefix);
        Integer startPage = pageNumber == null ? 1 : pageNumber;
        Query q = getEntityManager().createQuery("select c from Merchant c " +
            "where c.tradeName>=:key1 and c.tradeName<:key2 ")
            .setParameter("key1", prefix)
            .setParameter("key2", prefix + "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ")
            .setMaxResults(PAGE_COUNT)
            .setFirstResult((startPage - 1) * PAGE_COUNT);
        Query countQuery = getEntityManager().createQuery("select count(c) from Merchant c " +
            "where c.tradeName>=:key1 and c.tradeName<:key2 ")
            .setParameter("key1", prefix)
            .setParameter("key2", prefix + "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");

        SearchResultVO<MerchantVO> resultVO = new SearchResultVO<MerchantVO>();

        for (Merchant merchant : (List<Merchant>) q.getResultList()) {
            MerchantVO vo = new MerchantVO();
            //change image name
            if (!StringUtils.isBlank(merchant.getImageFileName())) {
                merchant.setImageFileName(merchant.getImageFileName());
            }
            vo.setMerchant(merchant);
            resultVO.getVoList().add(vo);
        }
        resultVO.setPageNum(startPage);
        resultVO.setTotal(((Long) countQuery.getSingleResult()).intValue() / PAGE_COUNT + 1);
        return resultVO;
    }

    @Override
    public List<Merchant> findLatestMerchant(Integer size) {
        assert size > 0;
        Query q = getEntityManager().createQuery("select c from Merchant c " +
            "where c.valid = true " +
            "order by c.postDate desc")
            .setMaxResults(size);

        return q.getResultList();
    }

    @Override
    public Long countMerchant() {
        Query q = getEntityManager().createQuery("select count(c) from Merchant c ");
        return (Long) q.getSingleResult();
    }

    @Override
    public Merchant findBestOfToday() {
        Query q = getEntityManager().createQuery("select c from Merchant c " +
            "where c.lastUpdateTime >= :startOfToday and c.lastUpdateTime < :endOfToday " +
            "order by c.lastUpdateTime, c.rank desc")
            .setParameter("startOfToday", DateUtils.getStartOfToday())
            .setParameter("endOfToday", DateUtils.getEndOfToday())
            .setMaxResults(1);

        return q.getResultList().size() > 0 ? (Merchant)q.getResultList().get(0) : null;
    }

    @Override
    public Merchant findHighOfRank() {
        Query q = getEntityManager().createQuery("select c from Merchant c " +
            "where c.lastUpdateTime >= :startOfToday and c.lastUpdateTime < :endOfToday " +
            "order by c.lastUpdateTime, c.rank desc")
            .setParameter("startOfToday", DateUtils.getStartOfToday())
            .setParameter("endOfToday", DateUtils.getEndOfToday())
            .setMaxResults(1);

        return q.getResultList().size() > 0 ? (Merchant)q.getResultList().get(0) : null;
    }

    @Override
    public Merchant findHottestOfWeek() {
        Query q = getEntityManager().createQuery("select c from Merchant c " +
            "where c.lastUpdateTime >= :startOfToday and c.lastUpdateTime < :endOfToday " +
            "order by c.lastUpdateTime, c.rank desc")
            .setParameter("startOfToday", DateUtils.getStartOfThisWeek())
            .setParameter("endOfToday", DateUtils.getEndOfThisWeek())
            .setMaxResults(1);

        return q.getResultList().size() > 0 ? (Merchant)q.getResultList().get(0) : null;
    }

    @Override
    public Merchant findRecommendOfToday() {
        Query q = getEntityManager().createQuery("select c from Merchant c " +
            "where c.createdOn >= :startOfToday and c.createdOn < :endOfToday " +
            "order by c.createdOn desc")
            .setParameter("startOfToday", DateUtils.getStartOfToday())
            .setParameter("endOfToday", DateUtils.getEndOfToday())
            .setMaxResults(1);

        return q.getResultList().size() > 0 ? (Merchant)q.getResultList().get(0) : null;
    }
}
