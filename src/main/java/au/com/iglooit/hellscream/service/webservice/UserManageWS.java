package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.model.vo.VersionResponse;
import au.com.iglooit.hellscream.security.AppRole;
import au.com.iglooit.hellscream.service.dao.UserDAO;
import au.com.iglooit.hellscream.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 30/08/2014
 * Time: 2:52 PM
 */
@Controller
public class UserManageWS {
    private static final Logger LOG = LoggerFactory.getLogger(UserManageWS.class);

    @Resource
    private UserDAO userDAO;



    @RequestMapping(value = "/ws/user",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse addUser(@RequestBody IGUser user) {
        LOG.info("register a new user : " + user.getEmail());
        user.setCreatedOn(DateUtils.getNow());
        user.setAuthorities(new HashSet<AppRole>(Arrays.asList(AppRole.USER)));
        userDAO.createUser(user);
        return new JsonResponse("OK", "");
    }
}
