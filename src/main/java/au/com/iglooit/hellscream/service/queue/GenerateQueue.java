package au.com.iglooit.hellscream.service.queue;

import au.com.iglooit.hellscream.model.entity.Suburb;
import au.com.iglooit.hellscream.service.dao.SuburbDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 22/10/2014
 * Time: 9:57 PM
 */
@Controller
public class GenerateQueue {
    private static final Logger LOG = LoggerFactory.getLogger(GenerateQueue.class);
    public static final String GENERATE_QUEUE_URL = "/pq/generate/";
    public static final String QUOTE_QUEUE_NAME = "generate-q";
    @Resource
    private SuburbDAO suburbDAO;

    @RequestMapping(value = GENERATE_QUEUE_URL,
            method = RequestMethod.POST)
    public ResponseEntity QuoteHandler(@RequestParam("name") String name,
                                       @RequestParam("postcode") String postcode,
                                       @RequestParam("state") String state,
                                       @RequestParam("lat") String latStr,
                                       @RequestParam("lng") String lngStr) {

        BigDecimal lat = convertToLocation(latStr);
        BigDecimal lng = convertToLocation(lngStr);
        Suburb current = suburbDAO.findByName(name);
        if (current != null) {
//                current.setName(name);
//                current.setPostCode(postcode);
//                LOG.info("update suburb -- " + current.getName());
//                suburbDAO.update(current);
        } else {
            Suburb suburb = new Suburb();
            suburb.setLatitude(lat);
            suburb.setLongitude(lng);
            suburb.setName(name);
            suburb.setPostCode(postcode);
            suburb.setState(state);
            LOG.info("create a new suburb -- " + suburb.getName());
            suburbDAO.createSuburb(suburb);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    private BigDecimal convertToLocation(String str) {
        return new BigDecimal(str);
    }
}
