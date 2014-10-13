package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.MerchantFeedbackMsg;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.model.vo.MerchantFeedbackMsgVO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.dao.MerchantFeedbackMsgDAO;
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
    private MerchantFeedbackMsgDAO merchantFeedbackMsgDAO;
    @Resource
    private MerchantDAO merchantDAO;

    @RequestMapping(value = "/ws/fd/m/{keyString}",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse addMerchantFeedback(@PathVariable String keyString, @RequestBody MerchantFeedbackMsg msg) {
        if (StringUtils.isBlank(keyString)) {
            return new JsonResponse(JsonResponse.Error, "Merchant key can not be blank.");
        }
        msg.setMerchantKey(KeyFactory.stringToKey(keyString));
        msg.setCreatedOn(DateUtils.getNow());
        merchantFeedbackMsgDAO.createMerchantFeedbackMsg(msg);
        // update merchant
        Merchant merchant = merchantDAO.findByKey(KeyFactory.stringToKey(keyString));
        merchant.setFeedbackCount(merchant.getFeedbackCount() + 1);
        merchant.setRank((merchant.getFeedbackCount() * merchant.getRank()
                + msg.getRank()) / merchant.getFeedbackCount());
        merchantDAO.update(merchant);
        return new JsonResponse(JsonResponse.OK, "");
    }

    @RequestMapping(value = "/ws/fd/m/latest",
            method = RequestMethod.GET)
    public
    @ResponseBody
    MerchantFeedbackMsgVO latestFeedback() {
        MerchantFeedbackMsg msg = merchantFeedbackMsgDAO.getLatestMsg();
        MerchantFeedbackMsgVO vo = new MerchantFeedbackMsgVO();
        if (msg != null) {
            vo.setComment(msg.getComment());
            vo.setPostDate(msg.getCreatedOn());
            vo.setRank(msg.getRank());
            vo.setUserEmail(msg.getUserEmail());
            vo.setUserName(msg.getUserName());
            Merchant merchant = merchantDAO.findByKey(msg.getMerchantKey());
            vo.setMerchantTradeName(merchant.getTradeName());
            vo.setMerchantUrl(merchant.getUrl());
        }
        return vo;
    }
}
