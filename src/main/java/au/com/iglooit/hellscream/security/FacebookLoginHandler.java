package au.com.iglooit.hellscream.security;

import com.face4j.facebook.Facebook;
import com.face4j.facebook.OAuthAccessToken;
import com.face4j.facebook.entity.User;
import com.face4j.facebook.exception.FacebookException;
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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 8/10/2014
 * Time: 8:08 AM
 */
public class FacebookLoginHandler {

    private static final String REGISTRATION_URL = "/register/u";
    private static final Logger LOG = LoggerFactory.getLogger(FacebookLoginHandler.class);

    private final AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> ads = new WebAuthenticationDetailsSource();
    private AuthenticationManager authenticationManager;
    private AuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

    public void authenticate(OAuthAccessToken oAuthAccessToken, HttpServletRequest request,
                             HttpServletResponse response) throws FacebookException, IOException, ServletException {
        Facebook facebook = Face4jFactory.getInstance().getFacebookFactory().getInstance(oAuthAccessToken);
        User fbUser = facebook.getCurrentUser();
        PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(fbUser, null);
        token.setDetails(ads.buildDetails((HttpServletRequest) request));

        try {
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            HttpSession session = request.getSession(true);
            session.setAttribute("username", fbUser.getEmail());

            LOG.info("Facebook user " + fbUser.getName());
            if (authentication.getAuthorities().contains(AppRole.NEW_USER)) {
                LOG.debug("New user authenticated. Redirecting to registration page");
                ((HttpServletResponse) response).sendRedirect(REGISTRATION_URL);

                return;
            }

        } catch (AuthenticationException e) {
            failureHandler.onAuthenticationFailure((HttpServletRequest) request, (HttpServletResponse) response,
                    e);

            return;
        }
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationFailureHandler getFailureHandler() {
        return failureHandler;
    }

    public void setFailureHandler(AuthenticationFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }
}
