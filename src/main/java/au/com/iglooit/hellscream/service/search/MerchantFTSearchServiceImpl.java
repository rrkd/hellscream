package au.com.iglooit.hellscream.service.search;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.service.IndexServiceHelp;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.utils.ListUtils;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.search.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 21/08/2014
 * Time: 4:41 PM
 */
@Component
public class MerchantFTSearchServiceImpl implements MerchantFTSearchService {
    @Resource
    private MerchantDAO merchantDAO;
    @Resource
    private IndexServiceHelp indexServiceHelp;

    @Override
    public List<Merchant> searchByKeyWord(String keyword, int from, int size) {
        List<Merchant> result = new ArrayList<>();
        if (StringUtils.isBlank(keyword)) {
            result = merchantDAO.findAllMerchants();
        } else {
            Index merchantIndex = indexServiceHelp.getMerchantIndex();
            Results<ScoredDocument> results = merchantIndex.search(keyword.replaceAll("-", " "));

            // Iterate over the documents in the results
            List<Merchant> merchantList = new ArrayList<Merchant>();
            for (ScoredDocument document : results) {
                Key key = KeyFactory.stringToKey(document.getId());
                Merchant merchant = (Merchant) merchantDAO.findByKey(key);
                if (merchant != null) {
                    merchantList.add(merchant);
                }
            }

            result = merchantList;
        }
        if (from >= 0 && size > 0) {
            return (List<Merchant>)ListUtils.getSubList(result, from, size);
        } else {
            return result;
        }
    }

    @Override
    public List<Merchant> searchByKeyWordAndLocal(String rawKeyword, String local, String rawCategory, int from, int size) {
        if (StringUtils.isBlank(local) && StringUtils.isBlank(rawCategory)) {
            return searchByKeyWord(rawKeyword, from, size);
        }
        Index merchantIndex = indexServiceHelp.getMerchantIndex();
        String keywords = rawKeyword.replaceAll("-", " ");
        String category = rawCategory.replaceAll("-", " ");
        String query = "";
        if(StringUtils.isNotBlank(keywords)) {
            query = keywords;
        }
        if (StringUtils.isNotBlank(local)) {
            if(StringUtils.isNotBlank(query)) {
                query = query + " AND ";
            }
            query = query + "(suburb=\"" + local + "\" OR postcode=\"" + local + "\")";
        }
        if (StringUtils.isNotBlank(category)) {
            if(StringUtils.isNotBlank(query)) {
                query = query + " AND ";
            }
            query = query + "(category=\"" + category + "\")";
        }

        QueryOptions request = QueryOptions.newBuilder()
                .setLimit(1000)
                .build();

        Query scQuery = Query.newBuilder()
                .setOptions(request)
                .build(query);

        Results<ScoredDocument> results = merchantIndex.search(scQuery);
        // Iterate over the documents in the results
        List<Merchant> merchantList = new ArrayList<Merchant>();
        for (ScoredDocument document : results) {
            Key key = KeyFactory.stringToKey(document.getId());
            Merchant merchant = (Merchant) merchantDAO.findByKey(key);
            if (merchant != null) {
                merchantList.add(merchant);
            }
        }
        if (from >= 0 && size > 0) {
            return (List<Merchant>)ListUtils.getSubList(merchantList, from, size);
        }
        return merchantList;
    }


}
