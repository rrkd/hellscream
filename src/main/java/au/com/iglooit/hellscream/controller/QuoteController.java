package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.security.GaeUserAuthentication;
import au.com.iglooit.hellscream.service.dao.CategoryGroupDAO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.dao.QuoteDAO;
import au.com.iglooit.hellscream.service.quote.QuoteService;
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
    public static final String QUOTE_TRANSACTION_URL = "/quote/t/";
    public static final String QUOTE_MERCHANT_QUERY_URL = "/quote/m/";
    @Resource
    private QuoteDAO quoteDAO;
    @Resource
    private MerchantDAO merchantDAO;
    @Resource
    private QuoteService quoteService;
    @Resource
    private CategoryGroupDAO categoryGroupDAO;

    @RequestMapping(value = "/quote/c", method = RequestMethod.GET)
    public ModelAndView postQuotePage() {
        ModelAndView modelAndView = new ModelAndView("quote/postQuote");
        modelAndView.addObject("categoryGroupList", categoryGroupDAO.loadAll());
        modelAndView.addObject("quoteList", quoteService.latestQuoteList());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof GaeUserAuthentication) {
            GaeUserAuthentication auth = (GaeUserAuthentication) authentication;
            if (auth.getPrincipal() != null) {
                if (auth.getPrincipal() instanceof IGUser) {
                    modelAndView.addObject("user", (IGUser) auth.getPrincipal());
                }
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/quote/d/{keyString}", method = RequestMethod.GET)
    public ModelAndView quoteDetails(@PathVariable String keyString) {
        ModelAndView modelAndView = new ModelAndView("quote/quoteDetails");
        Quote quote = quoteDAO.loadQuote(KeyFactory.stringToKey(keyString));
        modelAndView.addObject("quote", quote);
        modelAndView.addObject("quoteList", quoteService.latestQuoteList());
        return modelAndView;
    }

    @RequestMapping(value = QUOTE_TRANSACTION_URL + "{keyString}", method = RequestMethod.GET)
    public ModelAndView addQuoteTransaction(@PathVariable String keyString) {
        LOG.debug("create a new quote transaction for Quote: " + keyString);
        GaeUserAuthentication auth = (GaeUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        IGUser user = (IGUser) auth.getPrincipal();
        Merchant merchant = merchantDAO.findByKey(user.getMerchantKey());
        Quote quote = quoteDAO.loadQuote(KeyFactory.stringToKey(keyString));
        // check if merchant has apply this quote already
        Boolean bApplied = false;
        for(QuoteTransaction transaction : quote.getQuoteTransactions()) {
            if(transaction.getMerchant().getKey().equals(merchant.getKey())) {
                bApplied = true;
                break;
            }
        }

        ModelAndView modelAndView = new ModelAndView("quote/applyQuote");
        modelAndView.addObject("bApplied", bApplied);
        modelAndView.addObject("quote", quote);
        modelAndView.addObject("merchant", merchant);
        modelAndView.addObject("quoteList", quoteService.latestQuoteList());
        return modelAndView;
    }

    @RequestMapping(value = QUOTE_MERCHANT_QUERY_URL + "{keyString}", method = RequestMethod.GET)
    public ModelAndView merchantQuoteDetails(@PathVariable String keyString) {
        Quote quote = quoteDAO.loadQuote(KeyFactory.stringToKey(keyString));
        ModelAndView modelAndView = new ModelAndView("quote/merchantQuoteDetails");

        modelAndView.addObject("quote", quote);
        modelAndView.addObject("quoteList", quoteService.latestQuoteList());
        return modelAndView;
    }
}
