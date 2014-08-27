package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
import au.com.iglooit.hellscream.service.search.SuggestMerchantService;
import au.com.iglooit.hellscream.utils.MerchantIdentifierConvert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:49 AM
 */
@Controller
public class MerchantController {
    @Resource
    private MerchantManageService merchantManageService;
    @Resource
    private SuggestMerchantService suggestMerchantService;

    @RequestMapping(value = "/merchant", method = RequestMethod.GET)
    public ModelAndView merchantPage() {
        ModelAndView modelAndView = new ModelAndView("merchant");
        modelAndView.addObject("merchantList", merchantManageService.findAllMerchants());
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

}
