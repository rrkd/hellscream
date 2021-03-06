package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.model.entity.CategoryGroup;
import au.com.iglooit.hellscream.service.dao.CategoryDAO;
import au.com.iglooit.hellscream.service.dao.CategoryGroupDAO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import com.google.appengine.api.datastore.KeyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 25/08/2014
 * Time: 8:35 PM
 */
@Controller
public class CategoryController {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);
    @Resource
    private CategoryGroupDAO categoryGroupDAO;
    @Resource
    private MerchantDAO merchantDAO;
    @Resource
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView categoryPage() {
        ModelAndView modelAndView = new ModelAndView("category/categoryGroup");
        modelAndView.addObject("categoryGroupList", categoryGroupDAO.loadAll());
        return modelAndView;
    }

    @RequestMapping(value = "/category/{url}", method = RequestMethod.GET)
    public ModelAndView categoryPage(@PathVariable String url) {
        ModelAndView modelAndView = new ModelAndView("category/merchant-list");
        Category category = categoryDAO.findByCategoryUrl(url);
        if(category == null) {
            return new ModelAndView("redirect: /error/404");
        }
        modelAndView.addObject("category", category);
        modelAndView.addObject("merchantList", merchantDAO.findByCategoryName(category.getName()));
        return modelAndView;
    }

    @RequestMapping(value = "/categoryGroup/{url}", method = RequestMethod.GET)
    public ModelAndView categoryGroupPage(@PathVariable String url) {
        ModelAndView modelAndView = new ModelAndView("category/category");
        CategoryGroup categoryGroup = categoryGroupDAO.loadByUrl(url);
        modelAndView.addObject("categoryGroup", categoryGroup);
        return modelAndView;
    }
}
