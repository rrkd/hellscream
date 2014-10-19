package au.com.iglooit.hellscream.service.merchant;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.MerchantImportVO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 20/10/2014
 * Time: 9:17 AM
 */
@Component
public class MerchantImportServiceImpl implements MerchantImportService {
    private static final Logger LOG = LoggerFactory.getLogger(MerchantImportServiceImpl.class);
    @Resource
    private MerchantDAO merchantDAO;

    @Override
    public Merchant saveOrUpdateMerchant(MerchantImportVO vo) {
        String tradeName = vo.getTradeName();
        // check currently merchant
        Merchant targetMerchant = merchantDAO.findByTradeName(tradeName);
        if (targetMerchant == null) {
            targetMerchant = new Merchant();
            fillUpMerchant(targetMerchant, vo);
            merchantDAO.createMerchant(targetMerchant);
            LOG.info("create new merchant: " + tradeName);
        } else {
            fillUpMerchant(targetMerchant, vo);
            merchantDAO.modifyMerchant(targetMerchant);
            LOG.info("update merchant: " + tradeName);
        }
        return targetMerchant;
    }

    private void fillUpMerchant(Merchant targetMerchant, MerchantImportVO vo) {
        String tradeName = vo.getTradeName();
        String merchantName = vo.getMerchantName();
        String description = vo.getDescription();
        String address1 = vo.getAddress1();
        String address2 = vo.getAddress2();
        String address3 = vo.getAddress3();
        String email = vo.getEmail();
        String phone = vo.getPhone();
        String mobile = vo.getMobile();
        String contact1 = vo.getContact1();
        String contact2 = vo.getContact2();
        String category = vo.getCategory();

        targetMerchant.setTradeName(tradeName);
        targetMerchant.setMerchantName(merchantName);
        targetMerchant.setDescription(description);
        targetMerchant.setAddress1(address1);
        targetMerchant.setAddress2(address2);
        targetMerchant.setAddress3(address3);
        targetMerchant.setEmail(email);
        targetMerchant.setPhone(phone);
        targetMerchant.setMobile(mobile);
        targetMerchant.setContact1(contact1);
        targetMerchant.setContact2(contact2);
        List<String> categoryList = new ArrayList<>();
        if (StringUtils.isNotBlank(category)) {
            categoryList.add(category);
            targetMerchant.setCategoryList(categoryList);
        }
    }
}
