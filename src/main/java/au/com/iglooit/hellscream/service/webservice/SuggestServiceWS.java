package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.entity.QuoteFeedbackMsg;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.model.vo.QuoteVO;
import au.com.iglooit.hellscream.service.dao.QuoteFeedbackMsgDAO;
import au.com.iglooit.hellscream.service.quote.QuoteService;
import au.com.iglooit.hellscream.service.suggest.SuggestMerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 14/09/2014
 * Time: 3:34 PM
 */
@Controller
public class SuggestServiceWS {
    private static final Logger LOG = LoggerFactory.getLogger(SuggestServiceWS.class);
    @Resource
    private QuoteFeedbackMsgDAO quoteFeedbackMsgDAO;
    @Resource
    private QuoteService quoteService;
    @Resource
    private SuggestMerchantService suggestMerchantService;

    @RequestMapping(value = "/ws/ss/latestFeedbackMsg",
            method = RequestMethod.GET,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    QuoteFeedbackMsg latestQuoteFeedbackMsg() {
        return quoteFeedbackMsgDAO.getLatestQuoteFeedbackMsg();
    }

    @RequestMapping(value = "/ws/ss/latestQuote",
            method = RequestMethod.GET)
    public
    @ResponseBody
    List<QuoteVO> latestQuote() {
        LOG.info("[NICK] call latestQuote");
        List<QuoteVO> result = quoteService.latestQuoteList();
        LOG.info("[NICK] size of latestQuote is " + result.size());
        return result;
    }

    @RequestMapping(value = "/ws/suggest/merchant/update",
        method = RequestMethod.GET)
    public
    @ResponseBody
    JsonResponse updateSuggestMerchants() {
        LOG.info("[NICK] Update Suggest Merchant Data");
        suggestMerchantService.updateHomeSuggestMerchant();
        return new JsonResponse(JsonResponse.OK, "Update Suggest Merchant Data.");
    }
}
