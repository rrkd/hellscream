package au.com.iglooit.hellscream.service.search;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.service.IndexServiceHelp;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.utils.ListUtils;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.Results;
import com.google.appengine.api.search.ScoredDocument;
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
    public List<Merchant> searchByKeyWordAndLocal(String rawKeyword, String local, int from, int size) {
        if (StringUtils.isBlank(local)) {
            return searchByKeyWord(rawKeyword, from, size);
        }
        Index merchantIndex = indexServiceHelp.getMerchantIndex();
        String keywords = rawKeyword.replaceAll("-", " ");
        String query;
        if(StringUtils.isBlank(keywords)) {
            query = "(suburb=\"" + local + "\" OR postcode=\"" + local + "\")";
        } else {
            query = keywords + " AND (suburb=\"" + local + "\" OR postcode=\"" + local + "\")";
        }
        Results<ScoredDocument> results = merchantIndex.search(query);
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
