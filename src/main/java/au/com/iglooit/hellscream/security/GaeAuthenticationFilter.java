package au.com.iglooit.hellscream.security;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.UserOriginalSystem;
import au.com.iglooit.hellscream.service.dao.UserDAO;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.Assert;
import org.springframework.web.filter.GenericFilterBean;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Luke Taylor
 */
public class GaeAuthenticationFilter extends GenericFilterBean {
    @Resource
    private UserDAO userDAO;
    private static final String REGISTRATION_URL = "/register/u";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> ads = new WebAuthenticationDetailsSource();
    private AuthenticationManager authenticationManager;
    private AuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User googleUser = UserServiceFactory.getUserService().getCurrentUser();
        // only check the gae user
        if (!loggedInUserMatchesGaeUser(authentication, googleUser)) {
            SecurityContextHolder.clearContext();
            authentication = null;
            ((HttpServletRequest) request).getSession().invalidate();
        }

        if (authentication == null) {
            if (googleUser != null) {
                logger.debug("Currently logged on to GAE as user " + googleUser);
                logger.debug("Authenticating to Spring Security");
                // IGUser has returned after authenticating via GAE. Need to authenticate through Spring Security.
                PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(googleUser, null);
                token.setDetails(ads.buildDetails((HttpServletRequest) request));

                try {
                    authentication = authenticationManager.authenticate(token);
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    if (authentication.getAuthorities().contains(AppRole.NEW_USER)) {
                        logger.debug("New user authenticated. Redirecting to registration page");
                        ((HttpServletResponse) response).sendRedirect(REGISTRATION_URL);

                        return;
                    }

                } catch (AuthenticationException e) {
                    failureHandler.onAuthenticationFailure((HttpServletRequest) request, (HttpServletResponse) response,
                            e);

                    return;
                }
            }
        }
        if (authentication != null && authentication.getAuthorities().contains(AppRole.NEW_USER)) {
            SecurityContextHolder.clearContext();
            ((HttpServletRequest) request).getSession().invalidate();
            logger.debug("New user authenticated. Redirecting to registration page");
            ((HttpServletResponse) response).sendRedirect(REGISTRATION_URL);

            return;
        }

        chain.doFilter(request, response);
    }

    private boolean loggedInUserMatchesGaeUser(Authentication authentication, User googleUser) {
        if (authentication == null) {
            return false;
        }
        if(authentication.getPrincipal() instanceof  IGUser) {
            if(((IGUser)authentication.getPrincipal()).getUserOriginalSystem().equals(UserOriginalSystem.GOOGLE)) {
                if (googleUser == null) {
                    // IGUser has logged out of GAE but is still logged into application
                    return false;
                }

                IGUser gaeUser = (IGUser) authentication.getPrincipal();
                logger.debug("gae user " + gaeUser.getEmail());
                if (!gaeUser.getEmail().equals(googleUser.getEmail())) {
                    return false;
                }
                if (userDAO.findByEmail(googleUser.getEmail()) == null) {
                    return false;
                }
                return true;
            }
            else {
                // ignore checking
                return true;
            }

        } else {
            // invilad user, clear session
            return false;
        }


    }

    @Override
    public void afterPropertiesSet() throws ServletException {
        Assert.notNull(authenticationManager, "AuthenticationManager must be set");
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void setFailureHandler(AuthenticationFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }
}
