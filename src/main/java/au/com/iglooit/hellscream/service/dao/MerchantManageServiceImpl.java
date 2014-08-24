package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.repository.BaseRepository;
import au.com.iglooit.hellscream.service.IndexServiceHelp;
import au.com.iglooit.hellscream.service.search.GeoSearchService;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.search.Document;
import com.google.appengine.api.search.GeoPoint;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.PutException;
import com.google.appengine.repackaged.com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:55 AM
 */
@Component
public class MerchantManageServiceImpl extends BaseRepository<Merchant> implements MerchantManageService {
    private static final Logger LOG = LoggerFactory.getLogger(MerchantManageServiceImpl.class);
    @Resource
    private GeoSearchService geoSearchService;

    public MerchantManageServiceImpl() {
        super(Merchant.class);
    }

    @Override
    public List<Merchant> findAllMerchants() {
        List<Merchant> result = findAll();
        LOG.info("size:" + result.size());
        return result;
    }

    @Override
    public Merchant findByTradeName(String tradeName) {
        return findAll().get(0);
    }

    @Override
    public void createMerchant(Merchant merchant) {
        // find the geo point
        GeoPoint result = geoSearchService.convertGeoPoint(merchant.convertToAddress());
        if (result != null) {
            merchant.setLatitude(new BigDecimal(result.getLatitude()));
            merchant.setLongitude(new BigDecimal(result.getLongitude()));
        }
        add(merchant);
        // get full index
        Index merchantIndex = IndexServiceHelp.getMerchantIndex();
        // get geo index
        Index geoIndex = IndexServiceHelp.getGeoIndex();
        try {
            merchantIndex.put(merchant.toFullTextDocument());
            geoIndex.put(merchant.toGeoDocument());
        } catch (PutException e) {
            throw new AppX("Can't create document for " + merchant.getKey(), e);
        }
    }

    @Override
    public void modifyMerchant(Merchant merchant) {
        // find the geo point
        GeoPoint result = geoSearchService.convertGeoPoint(merchant.convertToAddress());
        if (result != null) {
            merchant.setLatitude(new BigDecimal(result.getLatitude()));
            merchant.setLongitude(new BigDecimal(result.getLongitude()));
        }
        update(merchant);
        // get full index
        Index merchantIndex = IndexServiceHelp.getMerchantIndex();
        // get geo index
        Index geoIndex = IndexServiceHelp.getGeoIndex();
        try {
            String docId = KeyFactory.keyToString(merchant.getKey());

            Document ftDocument = merchantIndex.get(docId);
            if(ftDocument != null) {
                merchantIndex.delete(new ImmutableList.Builder<String>()
                        .add(docId).build());
            }

            Document geoDocument = geoIndex.get(docId);
            if(geoDocument != null) {
                geoIndex.delete(new ImmutableList.Builder<String>()
                        .add(docId).build());
            }

            merchantIndex.put(merchant.toFullTextDocument());
            geoIndex.put(merchant.toGeoDocument());
        } catch (PutException e) {
            throw new AppX("Can't create document for " + merchant.getKey(), e);
        }
    }
}
