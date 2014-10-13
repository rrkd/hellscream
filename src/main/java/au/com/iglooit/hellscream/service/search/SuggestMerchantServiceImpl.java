package au.com.iglooit.hellscream.service.search;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.Suburb;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.dao.SuburbDAO;
import com.google.appengine.api.datastore.Key;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 25/08/2014
 * Time: 6:18 PM
 */
@Component
public class SuggestMerchantServiceImpl implements SuggestMerchantService {
    private static final Integer MAX_QUOTE_EMAIL_COUNT = 20;
    @Resource
    private MerchantDAO merchantDAO;
    @Resource
    private SuburbDAO suburbDAO;

    @Override
    public List<Merchant> similarMerchant(Key key, Integer count) {
        Integer size;
        size= merchantDAO.findAllMerchants().size()>count?count:merchantDAO.findAllMerchants().size();
        return merchantDAO.findAllMerchants().subList(0,size);
    }

    @Override
    public List<String> quoteMerchantEmail(Quote quote) {
        int index = 0;
        Set<String> result = new HashSet<>();
        // filter by category
        List<Merchant> merchantList = merchantDAO.findByCategoryName(quote.getCategoryList());
        if (quote.getSuburbKey() != null) {
            Suburb suburb = suburbDAO.findByKey(quote.getSuburbKey());
            // filter by suburb
            for (Merchant merchant : merchantList) {
                if (!StringUtils.isBlank(merchant.getEmail())
                        && merchant.getSuburb().equalsIgnoreCase(suburb.getName())) {
                    result.add(merchant.getEmail());
                    // update statistic
                    merchant.setQuoteCount(merchant.getQuoteCount() + 1);
                    merchantDAO.update(merchant);
                    if (result.size() > MAX_QUOTE_EMAIL_COUNT) {
                        return new ArrayList<>(result);
                    }
                }
            }
        }

        merchantList = merchantDAO.findMerchants(0, MAX_QUOTE_EMAIL_COUNT - result.size());
        for (Merchant merchant : merchantList) {
            if (!StringUtils.isBlank(merchant.getEmail())) {
                result.add(merchant.getEmail());
            }
        }
        return new ArrayList<>(result);
    }

    private Set<String> buildMerchantEmailList(List<Merchant> merchantList) {
        Set<String> result = new HashSet<>();
        for (Merchant merchant : merchantList) {
            if (!StringUtils.isBlank(merchant.getEmail())) {
                result.add(merchant.getEmail());
            }
        }
        return result;
    }
}
