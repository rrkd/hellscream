package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.service.dao.CategoryGroupManageService;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
import au.com.iglooit.hellscream.service.search.SuggestMerchantService;
import au.com.iglooit.hellscream.utils.MerchantIdentifierConvert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:49 AM
 */
@Controller
public class MerchantController {
    @Resource
    private MerchantManageService merchantManageService;
    @Resource
    private SuggestMerchantService suggestMerchantService;
    @Resource
    private CategoryGroupManageService categoryGroupManageService;

    @RequestMapping(value = "/merchant", method = RequestMethod.GET)
    public ModelAndView merchantPage(@RequestParam("p") Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 1;
        } else if (pageNumber < 1) {
            pageNumber = 1;
        }
        ModelAndView modelAndView = new ModelAndView("merchant");
        modelAndView.addObject("searchResultList", merchantManageService.findMerchants(pageNumber));
        return modelAndView;
    }

    @RequestMapping(value = "/merchant/details/{tradeNameUrl}", method = RequestMethod.GET)
    public ModelAndView merchantDetails(@PathVariable String tradeNameUrl) {
        String tradeName = MerchantIdentifierConvert.convertToTradeName(tradeNameUrl);
        ModelAndView modelAndView = new ModelAndView("merchant/details");
        Merchant merchant = merchantManageService.findByTradeName(tradeName);
        modelAndView.addObject("merchant", merchant);
        modelAndView.addObject("similarMerchants", suggestMerchantService.similarMerchant(merchant.getKey(), 4));
        return modelAndView;
    }

    @RequestMapping(value = "/merchant/create", method = RequestMethod.GET)
    public ModelAndView registerMerchantPage() {
        ModelAndView modelAndView = new ModelAndView("merchant/createMerchant");
        modelAndView.addObject("categoryGroupList", categoryGroupManageService.loadAll());
        return modelAndView;
    }

}
