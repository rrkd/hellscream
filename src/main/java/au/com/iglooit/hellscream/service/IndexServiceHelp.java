package au.com.iglooit.hellscream.service;

import com.google.appengine.api.search.GetIndexesRequest;
import com.google.appengine.api.search.GetResponse;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.IndexSpec;
import com.google.appengine.api.search.SearchServiceFactory;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 21/08/2014
 * Time: 11:43 AM
 */
public final class IndexServiceHelp {
    public static final String MERCHANT_INDEX_NAME = "merchantIndex";
    public static final String GEO_INDEX_NAME = "geoIndex";

    private IndexServiceHelp() {

    }

    public static Index getMerchantIndex() {
        GetResponse<Index> response = SearchServiceFactory.getSearchService().getIndexes(
                GetIndexesRequest.newBuilder().setSchemaFetched(true).build());
        // List out elements of Schema
        for (Index index : response) {
            if (index.getName().equals(MERCHANT_INDEX_NAME)) {
                return index;
            }
        }
        // create a new index;
        IndexSpec indexSpec = IndexSpec.newBuilder().setName(MERCHANT_INDEX_NAME).build();
        return SearchServiceFactory.getSearchService().getIndex(indexSpec);
    }

    public static Index getGeoIndex() {
        GetResponse<Index> response = SearchServiceFactory.getSearchService().getIndexes(
                GetIndexesRequest.newBuilder().setSchemaFetched(true).build());
        // List out elements of Schema
        for (Index index : response) {
            if (index.getName().equals(GEO_INDEX_NAME)) {
                return index;
            }
        }
        // create a new index;
        IndexSpec indexSpec = IndexSpec.newBuilder().setName(GEO_INDEX_NAME).build();
        return SearchServiceFactory.getSearchService().getIndex(indexSpec);
    }
}
