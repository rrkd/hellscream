package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.vo.VersionResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 4/10/2014
 * Time: 11:56 AM
 */
@Controller
public class VersionServiceWS {
    @RequestMapping(value = "/ws/user/version", method = RequestMethod.GET)
    public
    @ResponseBody
    VersionResponse versionResponse() {
        return new VersionResponse("1.0");
    }
}
