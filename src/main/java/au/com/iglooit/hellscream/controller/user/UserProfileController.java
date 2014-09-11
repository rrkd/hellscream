package au.com.iglooit.hellscream.controller.user;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.security.GaeUserAuthentication;
import au.com.iglooit.hellscream.service.dao.QuoteTransactionManageService;
import au.com.iglooit.hellscream.service.dao.UserManageService;
import au.com.iglooit.hellscream.service.quote.QuoteService;
import au.com.iglooit.hellscream.service.quote.QuoteTransactionService;
import com.google.appengine.api.datastore.KeyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 29/08/2014
 * Time: 7:29 AM
 */
@Controller
public class UserProfileController {
    private static final Logger LOG = LoggerFactory.getLogger(UserProfileController.class);

    @Resource
    private UserManageService userManageService;
    @Resource
    private QuoteService quoteService;
    @Resource
    private QuoteTransactionManageService quoteTransactionManageService;
    @Resource
    private QuoteTransactionService quoteTransactionService;

    @RequestMapping(value = "/u/p", method = RequestMethod.GET)
    public ModelAndView profilePage() {
        GaeUserAuthentication auth = (GaeUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        IGUser user = (IGUser) auth.getPrincipal();
        if (user.getMerchantKey() != null) {
            ModelAndView modelAndView = new ModelAndView("redirect:/merchant/p");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("u/userProfile");
            modelAndView.addObject("iguser", user);
            return modelAndView;
        }

    }

    @RequestMapping(value = "/u/q", method = RequestMethod.GET)
    public ModelAndView myQuotePage() {
        GaeUserAuthentication auth = (GaeUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        IGUser user = (IGUser) auth.getPrincipal();
        if (user == null) {
            LOG.error("You haven't login, please login firstly.");
            throw new AppX("User need to login ");
        }
        ModelAndView modelAndView = new ModelAndView("quote/myQuote");
        modelAndView.addObject("iguser", user);
        modelAndView.addObject("quoteList", quoteService.loadUserQuoteList(user.getEmail()));
        return modelAndView;
    }

    @RequestMapping(value = "/u/c/{transactionKeyString}", method = RequestMethod.GET)
    public ModelAndView contactMerchantPage(@PathVariable String transactionKeyString) {
        QuoteTransaction quoteTransaction = quoteTransactionManageService.findByKey(
                KeyFactory.stringToKey(transactionKeyString));
        if (quoteTransaction == null) {
            LOG.error("Transaction does NOT exist.");
            throw new AppX("Transaction does NOT exist");
        }
        quoteTransactionService.contactMerchant(quoteTransaction);
        ModelAndView modelAndView = new ModelAndView("quote/contactMerchant");
        modelAndView.addObject("quoteTransaction", quoteTransaction);
        return modelAndView;
    }
}
