package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.vo.HomeStatisticVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 4/10/2014
 * Time: 1:40 PM
 */
@Controller
public class StatisticServiceWS {
    @RequestMapping(value = "/ws/st/quoteCount",
            method = RequestMethod.GET)
    public
    @ResponseBody
    Integer quoteCount() {
        return 100;
    }

    @RequestMapping(value = "/ws/st/merchantCount",
            method = RequestMethod.GET)
    public
    @ResponseBody
    Integer merchantCount() {
        return 100;
    }

    @RequestMapping(value = "/ws/st/feedbackCount",
            method = RequestMethod.GET)
    public
    @ResponseBody
    Integer feedbackCount() {
        return 100;
    }

    @RequestMapping(value = "/ws/st/msgCount",
            method = RequestMethod.GET)
    public
    @ResponseBody
    Integer msgCount() {
        return 100;
    }

    @RequestMapping(value = "/ws/st/quoteCount/u/{keyString}",
            method = RequestMethod.GET)
    public
    @ResponseBody
    Integer userQuoteCount(@PathVariable String keyString) {
        return 100;
    }

    @RequestMapping(value = "/ws/st/quoteCount/m/{keyString}",
            method = RequestMethod.GET)
    public
    @ResponseBody
    Integer merchantQuoteCount(@PathVariable String keyString) {
        return 100;
    }

    @RequestMapping(value = "/ws/st/home",
            method = RequestMethod.GET)
    public
    @ResponseBody
    HomeStatisticVO homeStatisticData() {
        HomeStatisticVO vo = new HomeStatisticVO();
        vo.setFeedbackCount(100);
        vo.setMerchantCount(100);
        vo.setMsgCount(100);
        vo.setQuoteCount(100);
        return vo;
    }
}
