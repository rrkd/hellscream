package au.com.iglooit.hellscream.service.configuration;

import au.com.bytecode.opencsv.CSVReader;
import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.service.IndexServiceHelp;
import au.com.iglooit.hellscream.service.dao.SuburbDAO;
import au.com.iglooit.hellscream.service.queue.GenerateQueue;
import au.com.iglooit.hellscream.service.statistic.StatisticService;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import static com.google.appengine.api.taskqueue.TaskOptions.Builder.withUrl;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 24/09/2014
 * Time: 9:55 PM
 */
@Component
public class SuburbConfigureService {
    private static final Logger LOG = LoggerFactory.getLogger(SuburbConfigureService.class);
    private static final Integer SIZE = 1000;
    @Resource
    private SuburbDAO suburbDAO;
    @Resource
    private StatisticService statisticService;


    @PostConstruct
    public void init() throws Exception {
        LOG.info("init suburb");
        WebProperties webProperties = WebProperties.getInstance();
        Boolean initData = Boolean.valueOf(webProperties.get("init.suburb.data"));
        if (initData) {
            // delete category and categorygroup
            LOG.info("init model - please delete all data before doing this.");
            LOG.info("Start to load suburb data");
            initSuburb();
        }
    }

    private void initSuburb() throws IOException {
        Long startPoint = statisticService.suburbCount();
        Queue queue = QueueFactory.getQueue(GenerateQueue.SUBURB_QUEUE_NAME);
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("data/suburb.csv");
        CSVReader reader = new CSVReader(new InputStreamReader(is));
        String[] nextLine;
        int index = 0;
        while ((nextLine = reader.readNext()) != null) {
            index++;
            if (index >= startPoint && index < startPoint + SIZE) {
                String name = pickUpContent(nextLine[1].trim());
                String postcode = pickUpContent(nextLine[2].trim());
                String state = convertToState(nextLine[3].trim());
                BigDecimal lat = convertToLocation(nextLine[4].trim());
                BigDecimal lng = convertToLocation(nextLine[5].trim());

                queue.add(withUrl(GenerateQueue.GENERATE_QUEUE_URL)
                        .param("name", name)
                        .param("postcode", postcode)
                        .param("state", state)
                        .param("lat", nextLine[4].trim())
                        .param("lng", nextLine[5].trim()));
            }

        }
    }

    private String convertToState(String num) {
        switch (num) {
            case "1":
                return "QLD";
            case "2":
                return "NSW";
            case "3":
                return "ACT";
            case "4":
                return "VIC";
            case "5":
                return "SA";
            case "6":
                return "WA";
            case "7":
                return "NT";
            case "8":
                return "TAS";
            default:
                throw new AppX("Can't find state for " + num);
        }
    }

    private BigDecimal convertToLocation(String str) {
        return new BigDecimal(str);
    }

    private String pickUpContent(String str) {
        return str.substring(1, str.lastIndexOf("'"));
    }
}
