package au.com.iglooit.hellscream.service.suggest;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.vo.HomeSuggestMerchantVO;
import com.google.appengine.api.datastore.Key;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 25/08/2014
 * Time: 6:17 PM
 */
public interface SuggestMerchantService {
    List<Merchant> similarMerchant(Key key, Integer count);

    /**
     * based on the quote, pick up the merchant list.
     * @param quote
     * @return
     */
    List<String> quoteMerchantEmail(Quote quote);

    HomeSuggestMerchantVO homeSuggest();

    void updateHomeSuggestMerchant();
}
