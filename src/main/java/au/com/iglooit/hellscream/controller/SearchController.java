package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.service.dao.CategoryManageService;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
import au.com.iglooit.hellscream.service.search.MerchantFTSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 21/08/2014
 * Time: 4:27 PM
 */
@Controller
public class SearchController {
    @Resource
    private MerchantFTSearchService merchantFTSearchService;
    @Resource
    private CategoryManageService categoryManageService;
    @Resource
    private MerchantManageService merchantManageService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchPage(@RequestParam("q") String queryString) {
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("merchantList",
                merchantFTSearchService.searchByKeyWord(queryString.replaceAll(" ", "-")));
        return modelAndView;
    }

    @RequestMapping(value = "/search/c", method = RequestMethod.GET)
    public ModelAndView searchCategoryPage(@RequestParam("q") String queryString) {
        ModelAndView modelAndView = new ModelAndView("search");
        Category category = categoryManageService.findByCategoryUrl(queryString);
        if(category != null)
        {
            modelAndView.addObject("merchantList",
                    merchantManageService.findByCategoryName(category.getName()));
        } else {
            modelAndView.addObject("merchantList",null);
        }
        return modelAndView;
    }
}
