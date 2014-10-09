package au.com.iglooit.hellscream.security;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.UserOriginalSystem;
import au.com.iglooit.hellscream.service.dao.UserDAO;
import com.google.appengine.api.users.User;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.annotation.Resource;


/**
 * A simple authentication provider which interacts with {@code IGUser} returned by the GAE {@code UserService},
 * and also the local persistent {@code UserRegistry} to build an application user principal.
 * <p>
 * If the user has been authenticated through google accounts, it will check if they are already registered
 * and either load the existing user information or assign them a temporary identity with limited access until they
 * have registered.
 * <p>
 * If the account has been disabled, a {@code DisabledException} will be raised.
 *
 * @author Luke Taylor
 */
public class GoogleAccountsAuthenticationProvider implements AuthenticationProvider, MessageSourceAware {
    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
    @Resource
    private UserDAO userDAO;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        IGUser user = null;
        if(authentication.getPrincipal() instanceof User) {
            User googleUser = (User) authentication.getPrincipal();

            user = userDAO.findByEmail(googleUser.getEmail());
            if (user == null) {
                // IGUser not in registry. Needs to register
                IGUser rawUser = new IGUser(googleUser.getUserId(), googleUser.getNickname(), googleUser.getEmail());
                user = userDAO.signUpAsNewDefaultUser(rawUser);
            }
            user.setUserOriginalSystem(UserOriginalSystem.GOOGLE);
        } else if (authentication.getPrincipal() instanceof com.face4j.facebook.entity.User) {
            com.face4j.facebook.entity.User facebookUser = (com.face4j.facebook.entity.User) authentication.getPrincipal();
            user = userDAO.findByEmail(facebookUser.getEmail());

            if (user == null) {
                // IGUser not in registry. Needs to register
                IGUser rawUser = new IGUser("", facebookUser.getName(), facebookUser.getEmail());
                user = userDAO.signUpAsNewDefaultUser(rawUser);
            }
            user.setUserOriginalSystem(UserOriginalSystem.FACEBOOK);
        } else if (authentication.getPrincipal() instanceof IGUser) {
            user = userDAO.findByEmail(((IGUser)authentication.getPrincipal()).getEmail());

            if (user == null) {
                // IGUser not in registry. Needs to register
                IGUser rawUser = new IGUser("", "", user.getEmail());
                rawUser.setUserOriginalSystem(UserOriginalSystem.DB);
                user = userDAO.signUpAsNewDefaultUser(rawUser);
            }
            user.setUserOriginalSystem(UserOriginalSystem.DB);
        } else {
            throw new InvalidAuthenticationException("user is invalid");
        }

        if (!user.isEnabled()) {
            throw new DisabledException("Account is disabled");
        }

        return new GaeUserAuthentication(user, authentication.getDetails());
    }

    /**
     * Indicate that this provider only supports PreAuthenticatedAuthenticationToken (sub)classes.
     */
    public final boolean supports(Class<?> authentication) {
        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messages = new MessageSourceAccessor(messageSource);
    }
}
