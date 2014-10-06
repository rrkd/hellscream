package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.model.vo.MerchantVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.dao.UserDAO;
import au.com.iglooit.hellscream.service.merchant.MerchantService;
import com.google.appengine.api.datastore.KeyFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 3/10/2014
 * Time: 8:19 AM
 */
@Controller
public class AdminManageWS {
    @Resource
    private MerchantService merchantService;
    @Resource
    private MerchantDAO merchantDAO;
    @Resource
    private UserDAO userDAO;

    @RequestMapping(value = "/ws/ad/m/{pageNumber}",
            method = RequestMethod.GET)
    public
    @ResponseBody
    SearchResultVO<MerchantVO> getMerchantList(@PathVariable Integer pageNumber, @RequestParam("q") String keyword) {
        return merchantService.findMerchantByPrefix(keyword, pageNumber);
    }

    @RequestMapping(value = "/ws/ad/m/{keyString}/valid",
            method = RequestMethod.GET)
    public
    @ResponseBody
    JsonResponse changeMerchantStatus(@PathVariable String keyString, @RequestParam("v") Boolean valid) {
        Merchant merchant = merchantDAO.findByKey(KeyFactory.stringToKey(keyString));
        merchant.setValid(valid);
        merchantDAO.update(merchant);
        return new JsonResponse(JsonResponse.OK, "");
    }

    @RequestMapping(value = "/ws/ad/u/{pageNumber}",
            method = RequestMethod.GET)
    public
    @ResponseBody
    SearchResultVO<IGUser> getUserList(@PathVariable Integer pageNumber, @RequestParam("q") String keyword) {
        assert pageNumber != null;
        if (StringUtils.isBlank(keyword)) {
            return userDAO.findUserByPrefix(pageNumber);
        } else {
            return userDAO.findUserByPrefix(keyword, pageNumber);
        }

    }

    @RequestMapping(value = "/ws/ad/u/{keyString}/valid",
            method = RequestMethod.GET)
    public
    @ResponseBody
    JsonResponse changeUserStatus(@PathVariable String keyString, @RequestParam("v") Boolean valid) {
        IGUser user = userDAO.findByKey(KeyFactory.stringToKey(keyString));
        user.setValid(valid);
        userDAO.update(user);
        return new JsonResponse(JsonResponse.OK, "");
    }
}
