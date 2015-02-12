package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.vo.SuburbResponse;
import au.com.iglooit.hellscream.model.vo.SuburbVO;
import au.com.iglooit.hellscream.service.dao.SuburbDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 25/09/2014
 * Time: 1:28 PM
 */
@Controller
public class GeoServiceWS {
    @Resource
    private SuburbDAO suburbDAO;

    @RequestMapping(value = "/ws/geo/suburb",
            method = RequestMethod.GET)
    public
    @ResponseBody
    SuburbResponse getSuburbList(@RequestParam("q") String keyword) {
        SuburbResponse response = new SuburbResponse();
        response.setSuburbVOList(suburbDAO.findByKeyword(keyword));
        return response;
    }
    @RequestMapping(value = "/ws/geo/suburb/{canonicalSlugId}",
        method = RequestMethod.GET)
    public
    @ResponseBody
    SuburbResponse getSuburb(@PathVariable final String canonicalSlugId) {
        SuburbResponse response = new SuburbResponse();
        response.setSuburbVOList(new ArrayList<SuburbVO>(){
            {
                add(new SuburbVO(suburbDAO.findByCanonicalSlugId(canonicalSlugId)));
            }
        });
        return response;
    }
}
