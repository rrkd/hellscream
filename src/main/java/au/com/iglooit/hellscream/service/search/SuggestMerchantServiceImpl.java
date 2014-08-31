package au.com.iglooit.hellscream.service.search;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 25/08/2014
 * Time: 6:18 PM
 */
@Component
public class SuggestMerchantServiceImpl implements SuggestMerchantService {
    @Resource
    private MerchantManageService merchantManageService;

    @Override
    public List<Merchant> similarMerchant(Key key, Integer count) {
        return merchantManageService.findAllMerchants().subList(0, count);
    }
}
