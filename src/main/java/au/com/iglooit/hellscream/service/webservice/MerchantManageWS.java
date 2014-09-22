package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.security.AppRole;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
import au.com.iglooit.hellscream.service.dao.UserManageService;
import au.com.iglooit.hellscream.utils.DateUtils;
import com.google.appengine.api.datastore.KeyFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 18/08/2014
 * Time: 1:01 PM
 */
@Controller
public class MerchantManageWS {
    @Resource
    private MerchantManageService merchantManageService;
    @Resource
    private UserManageService userManageService;

    @RequestMapping(value = "/ws/merchant", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Merchant> findUser() {
        return merchantManageService.findAllMerchants();
    }

    @RequestMapping(value = "/ws/merchant",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse addMerchant(@RequestBody Merchant rawMerchant) {
        // check the email and trade name
        if (merchantManageService.checkExistMerchant(rawMerchant.getTradeName(), rawMerchant.getEmail())) {
            return new JsonResponse("Error", "Email or Trade name has been registered.");
        }
        rawMerchant.setPostDate(DateUtils.getNow());
        merchantManageService.createMerchant(rawMerchant);
        // create merchant admin user
        IGUser merchantAdmin = new IGUser();
        merchantAdmin.setEmail(rawMerchant.getEmail());
        merchantAdmin.setNickname(rawMerchant.getContact1());
        merchantAdmin.setAuthorities(EnumSet.of(AppRole.MERCHANT));
        merchantAdmin.setMerchantKey(rawMerchant.getKey());
        userManageService.createUser(merchantAdmin);
        return new JsonResponse("OK", "");
    }

    @RequestMapping(value = "/ws/merchant/{keyString}",
            method = RequestMethod.PUT,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse modifyMerchant(@PathVariable String keyString, @RequestBody Merchant rawMerchant) {
        if (StringUtils.isBlank(keyString)) {
            throw new AppX("Can not update merchant because key is null");
        }
        Merchant merchant = (Merchant) merchantManageService.findByKey(KeyFactory.stringToKey(keyString));
        merchant.setAddress1(rawMerchant.getAddress1());
        merchant.setAddress2(rawMerchant.getAddress2());
        merchant.setAddress3(rawMerchant.getAddress3());
        merchant.setContact1(rawMerchant.getContact1());
        merchant.setContact2(rawMerchant.getContact2());
        merchant.setDescription(rawMerchant.getDescription());
        merchant.setEmail(rawMerchant.getEmail());
        merchant.setMerchantName(rawMerchant.getMerchantName());
        merchant.setMobile(rawMerchant.getMobile());
        merchant.setPhone(rawMerchant.getPhone());
        merchant.setLastUpdateTime(new Date());
        merchant.setTradeName(rawMerchant.getTradeName());

        merchantManageService.modifyMerchant(merchant);
        return new JsonResponse("OK", "");
    }
}
