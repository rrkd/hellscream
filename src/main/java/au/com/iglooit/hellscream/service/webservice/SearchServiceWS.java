package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.service.mail.ContactUsEmailVO;
import au.com.iglooit.hellscream.service.search.MerchantFTSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 16/09/2014
 * Time: 4:23 PM
 */
@Controller
public class SearchServiceWS {
    @Resource
    private MerchantFTSearchService merchantFTSearchService;

    @RequestMapping(value = "/ws/search", method = RequestMethod.GET)
    public
    @ResponseBody
    JsonResponse contactUsEmail(@RequestParam String local, @RequestParam String key) {
        merchantFTSearchService.searchByKeyWordAndLocal(key, local);
        return new JsonResponse("OK", "");
    }
}
