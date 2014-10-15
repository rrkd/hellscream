package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.exception.MerchantManageException;
import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.model.vo.QuoteContactMsgVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.security.GaeUserAuthentication;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.dao.QuoteContactMsgDAO;
import au.com.iglooit.hellscream.service.dao.UserDAO;
import au.com.iglooit.hellscream.service.merchant.MerchantService;
import com.google.appengine.api.datastore.KeyFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 18/08/2014
 * Time: 1:01 PM
 */
@Controller
public class MerchantManageWS {
    private static final Logger LOG = LoggerFactory.getLogger(MerchantManageWS.class);
    @Resource
    private MerchantDAO merchantDAO;
    @Resource
    private UserDAO userDAO;
    @Resource
    private MerchantService merchantService;
    @Resource
    private QuoteContactMsgDAO quoteContactMsgDAO;

    @RequestMapping(value = "/ws/merchant", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Merchant> findUser() {
        return merchantDAO.findAllMerchants();
    }

    @RequestMapping(value = "/ws/{userKey}/listMerchant",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse addMerchant(@RequestBody Merchant rawMerchant, @PathVariable String userKey) {
        assert StringUtils.isNotBlank(userKey);

        try {
            IGUser user = userDAO.findByKey(KeyFactory.stringToKey(userKey));
            if(user == null) {
                LOG.error("Invalid user for merchant.");
                throw new AppX("Invalid user for merchant.");
            }
            merchantService.createMerchant(rawMerchant, user);
        } catch (MerchantManageException e) {
            return new JsonResponse(JsonResponse.Error, e.getMessage());
        }
        return new JsonResponse(JsonResponse.OK, "");
    }

    @RequestMapping(value = "/ws/merchant/{keyString}",
            method = RequestMethod.PUT,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse modifyMerchant(@PathVariable String keyString, @RequestBody Merchant rawMerchant) {
        WebProperties webProperties = WebProperties.getInstance();
        String driveHost = webProperties.get("driver.host");
        if (StringUtils.isBlank(keyString)) {
            throw new AppX("Can not update merchant because key is null");
        }
        Merchant merchant = (Merchant) merchantDAO.findByKey(KeyFactory.stringToKey(keyString));
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
        if(StringUtils.isNotBlank(rawMerchant.getImageResourceId())) {
            merchant.setImageFileName(driveHost + rawMerchant.getImageFileName());
            merchant.setImageResourceId(rawMerchant.getImageResourceId());
        }

        merchantDAO.modifyMerchant(merchant);
        return new JsonResponse("OK", "");
    }

    @RequestMapping(value = "/ws/merchant/{keyString}/cm/{pageNumber}",
            method = RequestMethod.GET)
    public
    @ResponseBody
    SearchResultVO<QuoteContactMsgVO> contactMsg(@PathVariable String keyString, @PathVariable Integer pageNumber) {
        assert StringUtils.isNotBlank(keyString);
        Merchant merchant = merchantDAO.findByKey(KeyFactory.stringToKey(keyString));
        return quoteContactMsgDAO.findContactMsg(merchant, pageNumber);
    }
}
