package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.model.entity.Suburb;
import au.com.iglooit.hellscream.service.dao.CategoryDAO;
import au.com.iglooit.hellscream.service.dao.CategoryGroupDAO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.dao.SuburbDAO;
import au.com.iglooit.hellscream.service.search.MerchantFTSearchService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;

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
    @Resource
    private SuburbDAO suburbDAO;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchPage(@RequestParam("q") String queryString,
                                   @RequestParam("suburb") String localString,
                                   @RequestParam("category") String categoryString) {
        Suburb suburb =suburbDAO.findByCanonicalSlugId(localString);
        String suburbKeyword = suburb == null ? "": suburb.getName();
        ModelAndView modelAndView = new ModelAndView("searchResult");
        modelAndView.addObject("categoryGroupList", categoryGroupDAO.loadAll());
        modelAndView.addObject("queryKey", queryString);
        modelAndView.addObject("merchantList",
            merchantFTSearchService.searchByKeyWordAndLocal(
                queryString.replaceAll(" ", "-"), suburbKeyword, categoryString, 0, -1));

        // add query parameter
        if(suburb != null) {
            modelAndView.addObject("filterSuburb", suburbDAO.findByCanonicalSlugId(localString));
        }
        if(StringUtils.isNotBlank(categoryString)) {
            modelAndView.addObject("filterCategory", categoryDAO.findByName(categoryString));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/search/c", method = RequestMethod.GET)
    public ModelAndView searchCategoryPage(@RequestParam("q") String queryString) {
        ModelAndView modelAndView = new ModelAndView("searchResult");
        final Category category = categoryDAO.findByCategoryUrl(queryString);
        if (category != null) {
            modelAndView.addObject("merchantList",
                merchantDAO.findByCategoryName(new ArrayList<String>() {
                    {
                        add(category.getName());
                        add(category.getTradeName());
                    }
                }));
            modelAndView.addObject("filterCategory", category);
        } else {
            modelAndView.addObject("merchantList", null);
        }
        return modelAndView;
    }
}
