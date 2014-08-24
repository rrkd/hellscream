package au.com.iglooit.hellscream.service.search;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.service.IndexServiceHelp;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.Results;
import com.google.appengine.api.search.ScoredDocument;
import com.google.appengine.repackaged.com.google.common.collect.ImmutableList;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
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
            ImmutableList.Builder<Merchant> builder = ImmutableList.builder();
            for (ScoredDocument document : results) {
                Key key = KeyFactory.stringToKey(document.getId());
                Merchant merchant = (Merchant) merchantManageService.findByKey(key);
                if (merchant != null) {
                    builder.add(merchant);
                }
            }
            return builder.build();
        }
    }
}
