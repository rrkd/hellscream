package au.com.iglooit.hellscream.service.statistic;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.service.dao.StatisticDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 4/10/2014
 * Time: 12:07 PM
 */
@Component
public class StatisticServiceImpl implements StatisticService {
    @Resource
    private StatisticDAO statisticDAO;

    @Override
    public Long quoteCount() {
        return statisticDAO.countQuote();
    }

    @Override
    public Long merchantCount() {
        return statisticDAO.countMerchant();
    }

    @Override
    public Long feedbackCount() {
        return statisticDAO.countQuoteFeedbackMsg();
    }

    @Override
    public Long msgCount() {
        return statisticDAO.countQuoteTransaction();
    }

    @Override
    public Long quoteCount(IGUser user) {
        return 100L;
    }

    @Override
    public Long quoteCount(Merchant merchant) {
        return 100L;
    }

    @Override
    public Long suburbCount() {
        return statisticDAO.countSuburb();
    }
}
