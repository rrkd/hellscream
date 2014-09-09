package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.security.GaeUserAuthentication;
import au.com.iglooit.hellscream.service.dao.CategoryGroupManageService;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
import au.com.iglooit.hellscream.service.dao.QuoteManageService;
import au.com.iglooit.hellscream.utils.MerchantIdentifierConvert;
import com.google.appengine.api.datastore.KeyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 1/09/2014
 * Time: 8:24 PM
 */
@Controller
public class QuoteController {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);
    @Resource
    private QuoteManageService quoteManageService;
    @Resource
    private MerchantManageService merchantManageService;
    @Resource
    private CategoryGroupManageService categoryGroupManageService;

    @RequestMapping(value = "/quote/c", method = RequestMethod.GET)
    public ModelAndView postQuotePage() {
        ModelAndView modelAndView = new ModelAndView("quote/postQuote");
        modelAndView.addObject("categoryGroupList", categoryGroupManageService.loadAll());
        return modelAndView;
    }

    @RequestMapping(value = "/quote/d/{keyString}", method = RequestMethod.GET)
    public ModelAndView quoteDetails(@PathVariable String keyString) {
        ModelAndView modelAndView = new ModelAndView("quote/quoteDetails");
        Quote quote = quoteManageService.loadQuote(KeyFactory.stringToKey(keyString));
        modelAndView.addObject("quote", quote);
        return modelAndView;
    }

    @RequestMapping(value = "/quote/t/{keyString}", method = RequestMethod.GET)
    public ModelAndView addQuoteTransaction(@PathVariable String keyString) {
        LOG.debug("create a new quote transaction for Quote: " + keyString);
        GaeUserAuthentication auth = (GaeUserAuthentication)SecurityContextHolder.getContext().getAuthentication();
        IGUser user = (IGUser)auth.getPrincipal();
        Merchant merchant = merchantManageService.findByKey(user.getMerchantKey());
        Quote quote = quoteManageService.loadQuote(KeyFactory.stringToKey(keyString));
        ModelAndView modelAndView = new ModelAndView("quote/applyQuote");

        modelAndView.addObject("quote", quote);
        modelAndView.addObject("merchant", merchant);
        return modelAndView;
    }
}
