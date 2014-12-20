package au.com.iglooit.hellscream.service.configuration;

import au.com.bytecode.opencsv.CSVReader;
import au.com.iglooit.hellscream.model.vo.MerchantImportVO;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.service.merchant.MerchantImportService;
import com.google.appengine.api.datastore.Text;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 16/10/2014
 * Time: 9:51 PM
 */
@Component
public class MerchantConfigureService {
    private static final Logger LOG = LoggerFactory.getLogger(MerchantConfigureService.class);
    private static final Integer TRADE_NAME = 0;
    private static final Integer MERCHANT_NAME = 1;
    private static final Integer DESCRIPTION = 2;
    private static final Integer ADDRESS1 = 3;
    private static final Integer ADDRESS2 = 4;
    private static final Integer ADDRESS3 = 5;
    private static final Integer EMAIL = 6;
    private static final Integer PHONE = 7;
    private static final Integer MOBILE = 8;
    private static final Integer CONTACT1 = 9;
    private static final Integer CONTACT2 = 10;
    private static final Integer CATEGORY = 11;
    @Resource
    private MerchantImportService merchantImportService;

    @PostConstruct
    public void init() throws Exception {
        WebProperties webProperties = WebProperties.getInstance();
        Boolean initData = Boolean.valueOf(webProperties.get("init.merchant.data"));
        if (initData) {
            LOG.info("init merchant data.");
            initMerchant();
        }
    }

    /**
     * tradeName,merchantName,description,address1,address2,address3,email,phone,mobile,contact1,contact2,categoryList;
     */
    private void initMerchant() throws IOException, URISyntaxException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

      //  InputStream is = classloader.getResourceAsStream("data/merchant.csv");

        URL merchantURL = classloader.getResource("data/merchant/");
        String[] merchantFiles=new File(merchantURL.toURI()).list();

        int j = 0;
        while (j < merchantFiles.length) {
        InputStream is = classloader.getResourceAsStream("data/merchant/" + merchantFiles[j]);
        CSVReader reader = new CSVReader(new InputStreamReader(is, "UTF-8"));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            String tradeName = nextLine[TRADE_NAME];
            if (StringUtils.isBlank(tradeName)) {
                continue;
            }
            merchantImportService.saveOrUpdateMerchant(fillUpMerchantImportVO(nextLine));
        }
            j++;
        }
    }

    private MerchantImportVO fillUpMerchantImportVO(String[] nextLine) {
        String tradeName = nextLine[TRADE_NAME];
        String merchantName = nextLine[MERCHANT_NAME];
        Text description = new Text( nextLine[DESCRIPTION]);
        String address1 = nextLine[ADDRESS1];
        String address2 = nextLine[ADDRESS2];
        String address3 = nextLine[ADDRESS3];
        String email = nextLine[EMAIL];
        String phone = nextLine[PHONE];
        String mobile = nextLine[MOBILE];
        String contact1 = nextLine[CONTACT1];
        String contact2 = nextLine[CONTACT2];
        String category = nextLine[CATEGORY];
        MerchantImportVO vo = new MerchantImportVO();
        vo.setTradeName(tradeName);
        vo.setMerchantName(merchantName);
        vo.setDescription(description);
        vo.setAddress1(address1);
        vo.setAddress2(address2);
        vo.setAddress3(address3);
        vo.setEmail(email);
        vo.setPhone(phone);
        vo.setMobile(mobile);
        vo.setContact1(contact1);
        vo.setContact2(contact2);
        vo.setCategory(category);
        return vo;
    }
}
