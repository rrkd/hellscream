package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.service.search.MerchantFTSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 21/08/2014
 * Time: 4:27 PM
 */
@Controller
public class SearchController {
    @Resource
    private MerchantFTSearchService merchantFTSearchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchPage(@RequestParam("q") String queryString) {
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("merchantList",
                merchantFTSearchService.searchByKeyWord(queryString.replaceAll(" ", "-")));
        return modelAndView;
    }
}
