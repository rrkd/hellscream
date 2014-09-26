package au.com.iglooit.hellscream.service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.Suburb;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.service.dao.SuburbDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 24/09/2014
 * Time: 9:55 PM
 */
@Component
public class SuburbConfigureService {
    private static final Logger LOG = LoggerFactory.getLogger(SuburbConfigureService.class);
    @Resource
    private SuburbDAO suburbDAO;
    @Resource
    private IndexServiceHelp indexServiceHelp;

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
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("data/suburb.csv");
        CSVReader reader = new CSVReader(new InputStreamReader(is));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            String name = pickUpContent(nextLine[1].trim());
            String postcode = pickUpContent(nextLine[2].trim());
            String state = convertToState(nextLine[3].trim());
            BigDecimal lat = convertToLocation(nextLine[4].trim());
            BigDecimal lng = convertToLocation(nextLine[5].trim());
            // update firstly
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
//                try {
//                    indexServiceHelp.getSuburbIndex().put(suburb.toFullTextDocument());
//                } catch (PutException e) {
//                    throw new AppX("Can't create document for " + suburb.getKey(), e);
//                }
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
