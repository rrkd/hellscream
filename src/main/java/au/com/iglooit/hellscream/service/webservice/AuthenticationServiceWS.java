package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.UserOriginalSystem;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.model.vo.LoginVO;
import au.com.iglooit.hellscream.security.LocalLoginHandler;
import au.com.iglooit.hellscream.service.dao.UserDAO;
import com.face4j.facebook.exception.FacebookException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 8/10/2014
 * Time: 1:01 PM
 */
@Controller
public class AuthenticationServiceWS {
    @Resource
    private UserDAO userDAO;
    @Resource
    private LocalLoginHandler localLoginHandler;

    @RequestMapping(value = "/ws/au/logincheck",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse checkUserEmail(@RequestBody LoginVO vo, HttpServletRequest request,
                                HttpServletResponse response) throws IOException, ServletException, FacebookException {
        if (userDAO.validUser(vo.getUsername(), vo.getPassword())) {
            return new JsonResponse(JsonResponse.OK, "");
        }
        return new JsonResponse(JsonResponse.Error, "");
    }


}
