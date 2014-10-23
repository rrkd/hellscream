package au.com.iglooit.hellscream.service.suburb;

import au.com.bytecode.opencsv.CSVReader;
import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.Suburb;
import au.com.iglooit.hellscream.service.IndexServiceHelp;
import au.com.iglooit.hellscream.service.dao.SuburbDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 21/10/2014
 * Time: 9:57 PM
 */
@Service
public class SuburbServiceImpl implements SuburbService {
    private static final Logger LOG = LoggerFactory.getLogger(SuburbServiceImpl.class);
    @Resource
    private SuburbDAO suburbDAO;
    @Resource
    private IndexServiceHelp indexServiceHelp;

    @Override
    public void initSuburb(Integer from, Integer size) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("data/suburb.csv");
        CSVReader reader = new CSVReader(new InputStreamReader(is));
        String[] nextLine;
        int index = 0;
        int initSize = 0;
        try {
            while ((nextLine = reader.readNext()) != null) {
                index++;
                if (index >= from) {
                    initSize++;
                    createOrUpdateSuburb(nextLine);
                }
                if (initSize > size) {
                    break;
                }
            }
        } catch (IOException e) {
            LOG.error("Can't load suburb from suburb.csv", e);
        }
    }

    private void createOrUpdateSuburb(String[] line) {
        String name = pickUpContent(line[1].trim());
        String postcode = pickUpContent(line[2].trim());
        String state = convertToState(line[3].trim());
        BigDecimal lat = convertToLocation(line[4].trim());
        BigDecimal lng = convertToLocation(line[5].trim());
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
        suburbDAO.getEntityManager().flush();
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
