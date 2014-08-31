package au.com.iglooit.hellscream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 30/08/2014
 * Time: 11:29 AM
 */
@Controller
public class ErrorController {
    @RequestMapping(value = "/error/{errorCode}")
    public final String errorCode(@PathVariable("errorCode") final String errorCode) {

        return "error/" + errorCode;
    }
}
