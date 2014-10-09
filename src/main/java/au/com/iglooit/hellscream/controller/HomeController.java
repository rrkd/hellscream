package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.service.merchant.MerchantService;
import au.com.iglooit.hellscream.service.quote.QuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 11/08/2014
 * Time: 8:56 PM
 */
@Controller
public class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    private final AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> ads = new WebAuthenticationDetailsSource();
    @Resource
    private QuoteService quoteService;
    @Resource
    private MerchantService merchantService;
    @Resource
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage(Locale locale) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("latestQuote", quoteService.latestQuoteList());
        modelAndView.addObject("latestMerchants", merchantService.findLatestMerchant());
        LOG.info("Welcome home! The client locale is {}.", locale);
        return modelAndView;
    }

    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public ModelAndView aboutUsPage() {
        ModelAndView modelAndView = new ModelAndView("aboutus");
        return modelAndView;
    }

    @RequestMapping(value = "/contactus", method = RequestMethod.GET)
    public ModelAndView contactUsPage() {
        ModelAndView modelAndView = new ModelAndView("contactus");
        return modelAndView;
    }

    @RequestMapping(value = "/faq", method = RequestMethod.GET)
    public ModelAndView faqPage() {
        ModelAndView modelAndView = new ModelAndView("faq");
        return modelAndView;
    }

    @RequestMapping(value = "/howitworks", method = RequestMethod.GET)
    public ModelAndView howItWorksPage() {
        ModelAndView modelAndView = new ModelAndView("howitworks");
        return modelAndView;
    }
}
