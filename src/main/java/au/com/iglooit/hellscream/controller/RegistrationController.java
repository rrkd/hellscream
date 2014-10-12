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

    @RequestMapping(value = "/register/user", method= RequestMethod.GET)
    public String userRegisterPage() {
        return "register/userRegister";
    }

    @RequestMapping(value = "/register/merchant", method= RequestMethod.GET)
    public String merchantRegisterPage() {
        return "register/merchantRegister";
    }

    @RequestMapping(value = "/register/user/success", method= RequestMethod.GET)
    public String userRegisterPageSuccess() {
        return "register/userRegisterSuccess";
    }
}
