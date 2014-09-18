package au.com.iglooit.hellscream.service;

import com.google.appengine.api.search.GetIndexesRequest;
import com.google.appengine.api.search.GetResponse;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.IndexSpec;
import com.google.appengine.api.search.SearchServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 21/08/2014
 * Time: 11:43 AM
 */
@Component
public class IndexServiceHelp {
    private static final Logger LOG = LoggerFactory.getLogger(IndexServiceHelp.class);

    public static final String MERCHANT_INDEX_NAME = "merchant_index";
    public static final String GEO_INDEX_NAME = "geo_index";
    private Index merchantIndex;
    private Index geoMerchantIndex;

    @PostConstruct
    public void init() throws Exception {
        LOG.info("init index");
        merchantIndex = initMerchantIndex();
        geoMerchantIndex = initMerchantGeoIndex();
    }

    private Index initMerchantIndex() {
        GetResponse<Index> response = SearchServiceFactory.getSearchService().getIndexes(
                GetIndexesRequest.newBuilder().setSchemaFetched(true).build());
        if (response != null) {
            // List out elements of Schema
            for (Index index : response) {
                if (index.getName().equals(MERCHANT_INDEX_NAME)) {
                    return index;
                }
            }
        }
        // create a new index;
        LOG.info("create new index " + MERCHANT_INDEX_NAME);
        IndexSpec indexSpec = IndexSpec.newBuilder().setName(MERCHANT_INDEX_NAME).build();
        return SearchServiceFactory.getSearchService().getIndex(indexSpec);
    }

    private Index initMerchantGeoIndex() {
        GetResponse<Index> response = SearchServiceFactory.getSearchService().getIndexes(
                GetIndexesRequest.newBuilder().setSchemaFetched(true).build());
        // List out elements of Schema
        if (response != null) {
            for (Index index : response) {
                if (index.getName().equals(GEO_INDEX_NAME)) {
                    return index;
                }
            }
        }
        // create a new index;
        LOG.info("create new index " + GEO_INDEX_NAME);
        IndexSpec indexSpec = IndexSpec.newBuilder().setName(GEO_INDEX_NAME).build();
        return SearchServiceFactory.getSearchService().getIndex(indexSpec);
    }

    public Index getMerchantIndex() {
        return merchantIndex;
    }

    public Index getGeoMerchantIndex() {
        return geoMerchantIndex;
    }
}
