package au.com.iglooit.hellscream.service.configuration;

import au.com.iglooit.hellscream.model.entity.*;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.service.dao.StatisticDAO;
import au.com.iglooit.hellscream.service.message.QuoteMerchantMsg;
import au.com.iglooit.hellscream.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 28/10/2014
 * Time: 11:15 AM
 */
@Component
public class StatisticConfigureService {
    private static final Logger LOG = LoggerFactory.getLogger(StatisticConfigureService.class);
    private static final String[] STATISTIC_LIST = new String[]{
            Merchant.class.getName(),
            Quote.class.getName(),
            QuoteMerchantMsg.class.getName(),
            QuoteTransaction.class.getName(),
            QuoteFeedbackMsg.class.getName(),
            Suburb.class.getName()
    };
    @Resource
    private StatisticDAO statisticDAO;
    @PostConstruct
    public void init() throws Exception {
        LOG.info("init statistic");
        WebProperties webProperties = WebProperties.getInstance();
        Boolean initData = Boolean.valueOf(webProperties.get("init.statistic.data"));
        if (initData) {
            // delete category and categorygroup
            LOG.info("init model - please delete all data before doing this.");
            LOG.info("Start to load suburb data");
            initStatistic();
        }
    }

    private void initStatistic() {
        for(String name : STATISTIC_LIST) {
            Statistic statistic = statisticDAO.findByName(name);
            if(statistic == null) {
                statistic = new Statistic();
                statistic.setStatisticCount(0L);
                statistic.setUpdateDate(DateUtils.getNow());
                statistic.setStatisticName(name);
                statisticDAO.createStatistic(statistic);
            }
        }
    }
}
