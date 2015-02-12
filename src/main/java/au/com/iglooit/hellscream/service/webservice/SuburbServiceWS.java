package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Suburb;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.service.dao.SuburbDAO;
import au.com.iglooit.hellscream.service.statistic.StatisticService;
import au.com.iglooit.hellscream.service.suburb.SuburbService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 21/10/2014
 * Time: 10:05 PM
 */
@Controller
public class SuburbServiceWS {
    private static final Integer TOTAL_SUBURB = 16387;
    @Resource
    private SuburbDAO suburbDAO;
    @Resource
    private SuburbService suburbService;
    @Resource
    private StatisticService statisticService;

    @RequestMapping(value = "/ws/suburb/init", method = RequestMethod.GET)
    public
    @ResponseBody
    JsonResponse initSuburbData() {

        suburbService.initSuburb(statisticService.suburbCount().intValue(), 1000);

        return new JsonResponse(JsonResponse.OK, "current Count is: " + statisticService.suburbCount().intValue());
    }
    @RequestMapping(value = "/ws/suburb/count", method = RequestMethod.GET)
    public
    @ResponseBody
    JsonResponse countSuburbData() {
        return new JsonResponse(JsonResponse.OK, "current Count is: " + statisticService.suburbCount().intValue());
    }

    @RequestMapping(value = "/ws/suburb", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse addSuburbData(@RequestBody Suburb suburb) {
        Suburb suburb1 = suburbDAO.findByName(suburb.getName());
        if(suburb1 == null) {
            suburbDAO.createSuburb(suburb);
            return new JsonResponse(JsonResponse.OK, "suburb created " + suburb.getName());
        }
        return new JsonResponse(JsonResponse.OK, "suburb exist");
    }
}
