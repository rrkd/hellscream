package au.com.iglooit.hellscream.service.merchant;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.MerchantVO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.utils.DateUtils;
import au.com.iglooit.hellscream.utils.MerchantIdentifierConvert;
import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 23/09/2014
 * Time: 9:06 AM
 */
@Component
public class MerchantServiceImpl implements MerchantService {
    @Resource
    private MerchantDAO merchantDAO;
    @Override
    public MerchantVO findMerchantByKey(Key key) {
        return generateMerchantVO(merchantDAO.findByKey(key));  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MerchantVO findMerchantByMerchantURL(String merchantURL) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void createMerchant(Merchant merchant) {
        merchant.setPostDate(DateUtils.getNow());
        merchant.setCanonicalSlugId(MerchantIdentifierConvert.convertToURL(merchant.getTradeName()));
    }

    private MerchantVO generateMerchantVO(Merchant merchant) {
        MerchantVO vo = new MerchantVO();
        vo.setMerchant(merchant);
        return vo;
    }
}
