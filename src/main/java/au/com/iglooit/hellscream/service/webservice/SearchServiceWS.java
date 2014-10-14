package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.service.search.MerchantFTSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
    List<Merchant> contactUsEmail(@RequestParam("local") String local, @RequestParam("q") String key,
                                @RequestParam("from") Integer from, @RequestParam("size") Integer size,
                                @RequestParam("category") String category) {
        if (size == null) {
            size = -1;
        }
        if (from == null) {
            from = 0;
        }
        return merchantFTSearchService.searchByKeyWordAndLocal(key, local, category, from, size);
    }
}
