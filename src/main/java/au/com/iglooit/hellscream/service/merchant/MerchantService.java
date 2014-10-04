package au.com.iglooit.hellscream.service.merchant;

import au.com.iglooit.hellscream.exception.MerchantManageException;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.MerchantVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import com.google.appengine.api.datastore.Key;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 23/09/2014
 * Time: 9:06 AM
 */
public interface MerchantService {
    MerchantVO findMerchantByKey(Key key);
    MerchantVO findMerchantByMerchantURL(String canonicalSlugId);
    void createMerchant(Merchant merchant) throws MerchantManageException;
    MerchantVO findByURL(String url);
    SearchResultVO<MerchantVO> findMerchantByPrefix(String prefix, Integer page);
    List<Merchant> findLatestMerchant();
}
