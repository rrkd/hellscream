package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.security.AppRole;
import au.com.iglooit.hellscream.security.GaeUserAuthentication;
import au.com.iglooit.hellscream.security.UserRegistry;
import com.google.appengine.api.users.UserServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 28/08/2014
 * Time: 4:01 PM
 */
@Controller
public class RegistrationController {
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);
    @Resource
    private UserRegistry registry;

    @RequestMapping(value = "/register/u", method= RequestMethod.GET)
    public String registerPage() {
        LOG.info("hit register user page.");
        return "register/userRegister";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid RegistrationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        IGUser currentUser = (IGUser)authentication.getPrincipal();
        Set<AppRole> roles = EnumSet.of(AppRole.USER);

        if (UserServiceFactory.getUserService().isUserAdmin()) {
            roles.add(AppRole.ADMIN);
        }

        IGUser IGUser = new IGUser(currentUser.getUserId(), currentUser.getNickname(), currentUser.getEmail(),
                form.getForename(), form.getSurname(), roles, true);

        registry.registerUser(IGUser);

        // Update the context with the full authentication
        SecurityContextHolder.getContext().setAuthentication(new GaeUserAuthentication(IGUser, authentication.getDetails()));

        return "redirect:/home";
    }
}
