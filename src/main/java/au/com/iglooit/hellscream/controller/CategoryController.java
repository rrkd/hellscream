package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.model.entity.CategoryGroup;
import au.com.iglooit.hellscream.service.dao.CategoryGroupManageService;
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
    private CategoryGroupManageService categoryGroupManageService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView categoryPage() {
        ModelAndView modelAndView = new ModelAndView("category/categoryGroup");
        modelAndView.addObject("categoryGroupList", categoryGroupManageService.loadAll());
        return modelAndView;
    }

    @RequestMapping(value = "/category/{keyString}", method = RequestMethod.GET)
    public ModelAndView categoryPage(@PathVariable String keyString) {
        ModelAndView modelAndView = new ModelAndView("category/category");
        CategoryGroup categoryGroup = categoryGroupManageService.loadByKey(KeyFactory.stringToKey(keyString));
        modelAndView.addObject("categoryGroup", categoryGroup);
        return modelAndView;
    }
}
