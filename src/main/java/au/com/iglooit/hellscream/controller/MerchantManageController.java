package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.service.dao.MerchantManageService;
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
public class MerchantManageController {
    @Resource
    private MerchantManageService merchantManageService;

    @RequestMapping(value = "/merchant", method = RequestMethod.GET)
    public ModelAndView merchantPage() {
        ModelAndView modelAndView = new ModelAndView("merchant");
        modelAndView.addObject("merchantList", merchantManageService.findAllMerchants());
        return modelAndView;
    }

    @RequestMapping(value = "/ad/merchant/create", method = RequestMethod.GET)
    public String merchantNewPage() {
        return "merchant/createMerchant";
    }

    @RequestMapping(value = "/merchant/details/{tradeNameUrl}", method = RequestMethod.GET)
    public ModelAndView merchantDetails(@PathVariable String tradeNameUrl) {
        String tradeName = MerchantIdentifierConvert.convertToTradeName(tradeNameUrl);
        ModelAndView modelAndView = new ModelAndView("merchant/details");
        modelAndView.addObject("merchant", merchantManageService.findByTradeName(tradeName));
        return modelAndView;
    }

    @RequestMapping(value = "/ad/merchant/{key}", method = RequestMethod.GET)
    public String merchantModifyPage() {
        return "merchant/createMerchant";
    }
}
