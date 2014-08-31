package au.com.iglooit.hellscream.service.search;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.service.IndexServiceHelp;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
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
    private MerchantManageService merchantManageService;

    @Override
    public List<Merchant> searchByKeyWord(String keyword) {
        if (StringUtils.isBlank(keyword)) {
            return merchantManageService.findAllMerchants();
        } else {
            Index merchantIndex = IndexServiceHelp.getMerchantIndex();
            Results<ScoredDocument> results = merchantIndex.search(keyword.replaceAll("-", " "));

            // Iterate over the documents in the results
            List<Merchant> merchantList = new ArrayList<Merchant>();
            for (ScoredDocument document : results) {
                Key key = KeyFactory.stringToKey(document.getId());
                Merchant merchant = (Merchant) merchantManageService.findByKey(key);
                if (merchant != null) {
                    merchantList.add(merchant);
                }
            }
            return merchantList;
        }
    }
}
