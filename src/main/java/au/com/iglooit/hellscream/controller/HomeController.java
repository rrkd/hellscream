package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.service.quote.QuoteService;
import com.google.appengine.api.users.UserServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @Resource
    private QuoteService quoteService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage(Locale locale) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("latestQuote", quoteService.latestQuoteList());
        LOG.info("Welcome home! The client locale is {}.", locale);
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method= RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();

        String logoutUrl = UserServiceFactory.getUserService().createLogoutURL("/loggedout");

        response.sendRedirect(logoutUrl);
    }

    @RequestMapping(value = "/loggedout", method= RequestMethod.GET)
    public String loggedOut() {
        return "loggedout";
    }
}
