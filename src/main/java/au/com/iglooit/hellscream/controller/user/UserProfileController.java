package au.com.iglooit.hellscream.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 29/08/2014
 * Time: 7:29 AM
 */
@Controller
public class UserProfileController {
    @RequestMapping(value = "/u/p", method = RequestMethod.GET)
    public ModelAndView merchantNewPage() {
        ModelAndView modelAndView = new ModelAndView("u/userProfile");
        return modelAndView;
    }
}
