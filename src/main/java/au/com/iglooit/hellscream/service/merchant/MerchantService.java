package au.com.iglooit.hellscream.service.merchant;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.MerchantVO;
import com.google.appengine.api.datastore.Key;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 23/09/2014
 * Time: 9:06 AM
 */
public interface MerchantService {
    MerchantVO findMerchantByKey(Key key);
    MerchantVO findMerchantByMerchantURL(String merchantURL);
    void createMerchant(Merchant merchant);
}
