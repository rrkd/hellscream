package au.com.iglooit.hellscream.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 28/08/2014
 * Time: 8:45 AM
 */
@Controller
public class UserManageController {
    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public ModelAndView userManagePage() {
        ModelAndView modelAndView = new ModelAndView("admin/userList");
        return modelAndView;
    }
}
