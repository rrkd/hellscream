package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.service.mail.ContactUsEmailVO;
import au.com.iglooit.hellscream.service.mail.EMailService;
import au.com.iglooit.hellscream.service.mail.QuoteEmailVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 16/09/2014
 * Time: 1:26 PM
 */
@Controller
public class EmailServiceWS {
    @Resource
    private EMailService eMailService;

    @RequestMapping(value = "/ws/email/contactUs",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse contactUsEmail(@RequestBody ContactUsEmailVO vo) {
        eMailService.sendContactUsEmail(vo);
        return new JsonResponse("OK", "");
    }

    @RequestMapping(value = "/ws/email/feedback",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse feedbackEmail(@RequestBody ContactUsEmailVO vo) {
        eMailService.sendContactUsEmail(vo);
        return new JsonResponse("OK", "");
    }

    @RequestMapping(value = "/ws/email/quote",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse quoteEmail(@RequestBody QuoteEmailVO vo) {
        eMailService.sendQuoteEmail(vo);
        return new JsonResponse("OK", "");
    }
}
