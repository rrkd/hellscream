package au.com.iglooit.hellscream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 11/08/2014
 * Time: 8:56 PM
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }
}
