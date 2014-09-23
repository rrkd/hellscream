package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.MerchantSearchResult;
import com.google.appengine.api.datastore.Key;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:50 AM
 */
public interface MerchantDAO extends IEntityService<Merchant> {
    List<Merchant> findAllMerchants();

    Merchant findByTradeName(String tradeName);

    void createMerchant(Merchant merchant);

    void modifyMerchant(Merchant merchant);

    List<Merchant> findByCategoryName(String categoryName);

    Boolean checkExistMerchant(String tradeName, String email);

    MerchantSearchResult findMerchants(Integer pageNumber);

    Merchant findByURL(String url);
}
