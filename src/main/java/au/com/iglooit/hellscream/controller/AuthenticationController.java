package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.UserOriginalSystem;
import au.com.iglooit.hellscream.security.Face4jFactory;
import au.com.iglooit.hellscream.security.FacebookLoginHandler;
import au.com.iglooit.hellscream.security.LocalLoginHandler;
import au.com.iglooit.hellscream.service.dao.UserDAO;
import com.face4j.facebook.OAuthAccessToken;
import com.face4j.facebook.enums.Display;
import com.face4j.facebook.enums.Permission;
import com.face4j.facebook.exception.FacebookException;
import com.face4j.facebook.factory.FacebookFactory;
import com.google.appengine.api.users.UserServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 8/10/2014
 * Time: 8:16 AM
 */
@Controller
public class AuthenticationController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    @Resource
    private FacebookLoginHandler facebookLoginHandler;
    @Resource
    private UserDAO userDAO;
    @Resource
    private LocalLoginHandler localLoginHandler;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SecurityContextHolder.clearContext();
        request.getSession().invalidate();

        String logoutUrl = UserServiceFactory.getUserService().createLogoutURL("/loggedout");

        response.sendRedirect(logoutUrl);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        SecurityContextHolder.getContext();

        String loginURL = UserServiceFactory.getUserService().createLoginURL("/home");

        FacebookFactory facebookFactory = Face4jFactory.getInstance().getFacebookFactory();

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("googleUrl", loginURL);
        modelAndView.addObject("facebookUrl",
                facebookFactory.getRedirectURL("http://spring-forest-538.appspot.com/login_fb", Display.POPUP,
                        Permission.EMAIL,
                        Permission.OFFLINE_ACCESS));
        return modelAndView;

    }

    @RequestMapping(value = "/login_fb")
    public void loginFaceBook(HttpServletRequest request,
                              HttpServletResponse response) throws FacebookException, IOException, ServletException {
        String code = request.getParameter("code");
        OAuthAccessToken accessToken = Face4jFactory.getInstance().getFacebookFactory().getOAuthAccessToken(code,
                "http://spring-forest-538.appspot.com/login_fb");

        facebookLoginHandler.authenticate(accessToken, request, response);
        response.sendRedirect("/home");
    }

    @RequestMapping(value = "/loggedout", method = RequestMethod.GET)
    public String loggedOut() {
        return "loggedout";
    }

    @RequestMapping(value = "/loginrd",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            headers = "Content-type=application/x-www-form-urlencoded")
    public void redirect(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException, FacebookException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (userDAO.validUser(username, password)) {
            // tempare user for auth
            IGUser user = new IGUser("", "", username);
            user.setUserOriginalSystem(UserOriginalSystem.DB);
            localLoginHandler.authenticate(user, request, response);
            response.sendRedirect("/home");
        } else {
            response.sendRedirect("/error/500");
        }
    }
}
