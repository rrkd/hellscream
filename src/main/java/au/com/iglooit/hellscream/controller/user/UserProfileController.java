package au.com.iglooit.hellscream.controller.user;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.security.GaeUserAuthentication;
import au.com.iglooit.hellscream.service.dao.QuoteManageService;
import au.com.iglooit.hellscream.service.dao.UserManageService;
import au.com.iglooit.hellscream.service.quote.QuoteService;
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

    @RequestMapping(value = "/u/p/{keyString}", method = RequestMethod.GET)
    public ModelAndView profilePage(@PathVariable String keyString) {
        ModelAndView modelAndView = new ModelAndView("u/userProfile");
        modelAndView.addObject("iguser", userManageService.findByKey(KeyFactory.stringToKey(keyString)));
        return modelAndView;
    }

    @RequestMapping(value = "/u/q", method = RequestMethod.GET)
    public ModelAndView myQuotePage() {
        GaeUserAuthentication auth = (GaeUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        IGUser user = (IGUser)auth.getPrincipal();
        if( user == null) {
            LOG.error("You haven't login, please login firstly.");
            throw new AppX("User need to login ");
        }
        ModelAndView modelAndView = new ModelAndView("quote/myQuote");
        modelAndView.addObject("iguser", user);
        modelAndView.addObject("quoteList", quoteService.loadUserQuoteList(user.getEmail()));
        return modelAndView;
    }
}
