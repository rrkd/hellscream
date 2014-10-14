package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.service.dao.CategoryDAO;
import au.com.iglooit.hellscream.service.dao.CategoryGroupDAO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
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
    private CategoryDAO categoryDAO;
    @Resource
    private MerchantDAO merchantDAO;
    @Resource
    private CategoryGroupDAO categoryGroupDAO;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchPage(@RequestParam("q") String queryString, @RequestParam("local") String localString) {
        ModelAndView modelAndView = new ModelAndView("searchResult");
        modelAndView.addObject("categoryGroupList", categoryGroupDAO.loadAll());
        modelAndView.addObject("merchantList",
                merchantFTSearchService.searchByKeyWordAndLocal(
                        queryString.replaceAll(" ", "-"), localString, "", 0, -1));
        return modelAndView;
    }

    @RequestMapping(value = "/search/c", method = RequestMethod.GET)
    public ModelAndView searchCategoryPage(@RequestParam("q") String queryString) {
        ModelAndView modelAndView = new ModelAndView("search");
        Category category = categoryDAO.findByCategoryUrl(queryString);
        if (category != null) {
            modelAndView.addObject("merchantList",
                    merchantDAO.findByCategoryName(category.getName()));
        } else {
            modelAndView.addObject("merchantList", null);
        }
        return modelAndView;
    }
}
