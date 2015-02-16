package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.vo.MerchantVO;
import au.com.iglooit.hellscream.security.GaeUserAuthentication;
import au.com.iglooit.hellscream.service.dao.CategoryGroupDAO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.feedback.FeedbackService;
import au.com.iglooit.hellscream.service.merchant.MerchantService;
import au.com.iglooit.hellscream.service.suggest.SuggestMerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private static final Logger LOG = LoggerFactory.getLogger(MerchantController.class);
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

    @RequestMapping(value = "/m/create", method = RequestMethod.GET)
    public ModelAndView registerMerchantPage() {
        IGUser user = currentUser();
        if(user.getIsMerchant()) {
            //redirect to merchant profile
            ModelAndView modelAndView = new ModelAndView("merchant/profile");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("merchant/createMerchant");
        modelAndView.addObject("categoryGroupList", categoryGroupDAO.loadAll());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    private IGUser currentUser() {
        GaeUserAuthentication auth = (GaeUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        IGUser user = (IGUser) auth.getPrincipal();
        if (user == null) {
            LOG.error("You haven't login, please login firstly.");
            throw new AppX("User need to login ");
        }

        return user;
    }

}
