package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.UserOriginalSystem;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.model.vo.VersionResponse;
import au.com.iglooit.hellscream.security.AppRole;
import au.com.iglooit.hellscream.service.dao.UserDAO;
import au.com.iglooit.hellscream.utils.DateUtils;
import com.google.appengine.api.datastore.KeyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
        user.setUserOriginalSystem(UserOriginalSystem.DB);
        userDAO.createUser(user);
        return new JsonResponse("OK", "");
    }

    @RequestMapping(value = "/ws/user/{userKeyString}",
            method = RequestMethod.PUT,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse addUser(@RequestBody IGUser rawUser, @PathVariable String userKeyString) {
        LOG.info("modify user : " + rawUser.getEmail());
        IGUser user = userDAO.findByKey(KeyFactory.stringToKey(userKeyString));
        user.setAddress1(rawUser.getAddress1());
        user.setAddress2(rawUser.getAddress2());
        user.setAddress3(rawUser.getAddress3());
        user.setForename(rawUser.getForename());
        user.setNickname(rawUser.getNickname());
        user.setSurname(rawUser.getSurname());
        user.setMobile(rawUser.getMobile());

        userDAO.update(user);
        return new JsonResponse("OK", "");
    }
}
