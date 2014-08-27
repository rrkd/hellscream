package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Merchant;
import com.google.appengine.api.datastore.Key;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:50 AM
 */
public interface MerchantManageService extends IEntityService<Merchant> {
    List<Merchant> findAllMerchants();

    Merchant findByTradeName(String tradeName);

    void createMerchant(Merchant merchant);

    void modifyMerchant(Merchant merchant);
}
