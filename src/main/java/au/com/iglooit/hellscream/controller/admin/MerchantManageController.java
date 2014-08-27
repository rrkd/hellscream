package au.com.iglooit.hellscream.controller.admin;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.service.dao.CategoryGroupManageService;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
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
 * User: nicholas.zhu
 * Date: 24/08/2014
 * Time: 10:01 AM
 */
@Controller
public class MerchantManageController {
    private static final Logger LOG = LoggerFactory.getLogger(MerchantManageController.class);
    @Resource
    private MerchantManageService merchantManageService;
    @Resource
    private CategoryGroupManageService categoryGroupManageService;

    @RequestMapping(value = "/ad/merchant/create", method = RequestMethod.GET)
    public ModelAndView merchantNewPage() {
        ModelAndView modelAndView = new ModelAndView("merchant/createMerchant");
        modelAndView.addObject("categoryGroupList", categoryGroupManageService.loadAll());
        return modelAndView;
    }

    @RequestMapping(value = "/ad/merchant/{key}", method = RequestMethod.GET)
    public ModelAndView merchantModifyPage(@PathVariable String key) {
        LOG.info("hit the merchantModifyPage with " + key);
        ModelAndView modelAndView = new ModelAndView("ad/merchantManage");
        Merchant merchant = (Merchant)merchantManageService.findByKey(KeyFactory.stringToKey(key));
        if(merchant == null) {
            LOG.error("Can not find Merchant by " + key);
        }
        modelAndView.addObject("merchant", merchant);
        modelAndView.addObject("categoryGroupList", categoryGroupManageService.loadAll());
        return modelAndView;
    }
}
