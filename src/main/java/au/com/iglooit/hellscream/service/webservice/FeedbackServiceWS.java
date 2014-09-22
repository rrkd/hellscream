package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.MerchantFeedbackMsg;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.model.vo.MerchantFeedbackMsgVO;
import au.com.iglooit.hellscream.service.dao.MerchantFeedbackMsgManageService;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
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

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 22/09/2014
 * Time: 1:31 PM
 */
@Controller
public class FeedbackServiceWS {
    @Resource
    private MerchantFeedbackMsgManageService merchantFeedbackMsgManageService;
    @Resource
    private MerchantManageService merchantManageService;

    @RequestMapping(value = "/ws/fd/m/{keyString}",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse addMerchant(@PathVariable String keyString, @RequestBody MerchantFeedbackMsg msg) {
        if(StringUtils.isBlank(keyString)) {
            return new JsonResponse(JsonResponse.Error, "Merchant key can not be blank.");
        }
        msg.setMerchantKey(KeyFactory.stringToKey(keyString));
        msg.setCreatedOn(DateUtils.getNow());
        merchantFeedbackMsgManageService.createMerchantFeedbackMsg(msg);
        return new JsonResponse(JsonResponse.OK, "");
    }

    @RequestMapping(value = "/ws/fd/m/latest",
            method = RequestMethod.GET)
    public
    @ResponseBody
    MerchantFeedbackMsgVO latestFeedback() {
        MerchantFeedbackMsg msg = merchantFeedbackMsgManageService.getLatestMsg();
        MerchantFeedbackMsgVO vo = new MerchantFeedbackMsgVO();
        vo.setComment(msg.getComment());
        vo.setPostDate(msg.getCreatedOn());
        vo.setRank(msg.getRank());
        vo.setUserEmail(msg.getUserEmail());
        vo.setUserName(msg.getUserName());
        Merchant merchant = merchantManageService.findByKey(msg.getMerchantKey());
        vo.setMerchantTradeName(merchant.getTradeName());
        vo.setMerchantUrl(merchant.getUrl());
        return vo;
    }
}
