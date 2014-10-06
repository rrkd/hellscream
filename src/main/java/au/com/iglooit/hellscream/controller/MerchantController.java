package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.vo.MerchantVO;
import au.com.iglooit.hellscream.service.dao.CategoryGroupDAO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.feedback.FeedbackService;
import au.com.iglooit.hellscream.service.merchant.MerchantService;
import au.com.iglooit.hellscream.service.search.SuggestMerchantService;
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
    private MerchantDAO merchantDAO;
    @Resource
    private MerchantService merchantService;
    @Resource
    private SuggestMerchantService suggestMerchantService;
    @Resource
    private CategoryGroupDAO categoryGroupDAO;
    @Resource
    private FeedbackService feedbackService;

    @RequestMapping(value = "/merchant", method = RequestMethod.GET)
    public ModelAndView merchantPage(@RequestParam("p") Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 1;
        } else if (pageNumber < 1) {
            pageNumber = 1;
        }
        ModelAndView modelAndView = new ModelAndView("merchant");
        modelAndView.addObject("searchResultList", merchantDAO.findMerchants(pageNumber));
        return modelAndView;
    }

    @RequestMapping(value = "/merchant/details/{canonicalSlugId}", method = RequestMethod.GET)
    public ModelAndView merchantDetails(@PathVariable String canonicalSlugId) {
        MerchantVO merchant = merchantService.findMerchantByMerchantURL(canonicalSlugId);
        if (merchant == null) {
            return new ModelAndView("redirect: /error/404");
        }
        ModelAndView modelAndView = new ModelAndView("merchant/details");
        modelAndView.addObject("vo", merchant);
        modelAndView.addObject("similarMerchants", suggestMerchantService.similarMerchant(
                merchant.getMerchant().getKey(), 4));
        modelAndView.addObject("feedBackList",
                feedbackService.findFeedbackForMerchant(merchant.getMerchant().getKey(), 5));
        return modelAndView;
    }

    @RequestMapping(value = "/merchant/create", method = RequestMethod.GET)
    public ModelAndView registerMerchantPage() {
        ModelAndView modelAndView = new ModelAndView("merchant/createMerchant");
        modelAndView.addObject("categoryGroupList", categoryGroupDAO.loadAll());
        return modelAndView;
    }

    @RequestMapping(value = "/merchant/update/{tradeNameUrl}", method = RequestMethod.GET)
    public ModelAndView updatePage(@PathVariable String tradeNameUrl) {
        MerchantVO merchant = merchantService.findMerchantByMerchantURL(tradeNameUrl);
        if (merchant == null) {
            return new ModelAndView("redirect: /error/404");
        }
        ModelAndView modelAndView = new ModelAndView("merchant/updateMerchant");
        modelAndView.addObject("vo", merchant);
        modelAndView.addObject("categoryGroupList", categoryGroupDAO.loadAll());
        return modelAndView;
    }

}
