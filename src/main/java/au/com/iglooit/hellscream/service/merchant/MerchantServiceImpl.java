package au.com.iglooit.hellscream.service.merchant;

import au.com.iglooit.hellscream.exception.MerchantManageException;
import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.MerchantVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import au.com.iglooit.hellscream.security.AppRole;
import au.com.iglooit.hellscream.service.dao.CategoryDAO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.dao.UserDAO;
import au.com.iglooit.hellscream.utils.CanonicalSlugIdConvert;
import au.com.iglooit.hellscream.utils.DateUtils;
import com.google.appengine.api.datastore.Key;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.EnumSet;
import java.util.List;

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
    @Resource
    private UserDAO userDAO;
    @Resource
    private CategoryDAO categoryDAO;

    @Override
    public MerchantVO findMerchantByKey(Key key) {
        return generateMerchantVO(merchantDAO.findByKey(
                key));  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MerchantVO findMerchantByMerchantURL(String canonicalSlugId) {
        return generateMerchantVO(merchantDAO.findByURL(
                canonicalSlugId));  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void createMerchant(Merchant merchant, IGUser user) throws MerchantManageException {
        if (merchantDAO.checkExistMerchant(merchant.getTradeName(), merchant.getEmail())) {
            throw new MerchantManageException("Duplicated merchant name: " + merchant.getTradeName());
        }
        merchant.setPostDate(DateUtils.getNow());
        merchant.setCanonicalSlugId(CanonicalSlugIdConvert.convertToURL(merchant.getTradeName()));
        merchantDAO.createMerchant(merchant);
        // create merchant admin user
        user.setAuthorities(EnumSet.of(AppRole.MERCHANT, AppRole.USER));
        user.setMerchantKey(merchant.getKey());
        userDAO.update(user);
        // update category count
        for (String categoryTradeName : merchant.getCategoryList()) {
            Category category = categoryDAO.findByTradeName(categoryTradeName);
            if (category != null) {
                category.setMerchantCount(category.getMerchantCount() + 1);
                categoryDAO.update(category);
            }
        }
    }

    @Override
    public MerchantVO findByURL(String url) {
        return generateMerchantVO(merchantDAO.findByURL(url));
    }

    @Override
    public SearchResultVO<MerchantVO> findMerchantByPrefix(String prefix, Integer page) {
        if (StringUtils.isNotBlank(prefix)) {
            return merchantDAO.findMerchants(prefix, page);
        }
        return merchantDAO.findMerchants(page);
    }

    @Override
    public List<Merchant> findLatestMerchant() {
        return merchantDAO.findLatestMerchant(3);
    }

    private MerchantVO generateMerchantVO(Merchant merchant) {
        if (merchant == null) {
            return null;
        }
        MerchantVO vo = new MerchantVO();
        vo.setMerchant(merchant);
        vo.setRank(merchant.getRank());
        return vo;
    }
}
