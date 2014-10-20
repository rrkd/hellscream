package au.com.iglooit.hellscream.service.statistic;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.dao.QuoteDAO;
import au.com.iglooit.hellscream.service.feedback.FeedbackService;
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
    private MerchantDAO merchantDAO;
    @Resource
    private QuoteDAO quoteDAO;
    @Resource
    private FeedbackService feedbackService;

    @Override
    public Long quoteCount() {
        return quoteDAO.countQuote();
    }

    @Override
    public Long merchantCount() {
        return merchantDAO.countMerchant();
    }

    @Override
    public Long feedbackCount() {
        return feedbackService.countFeedback();
    }

    @Override
    public Long msgCount() {
        return 100L;
    }

    @Override
    public Long quoteCount(IGUser user) {
        return 100L;
    }

    @Override
    public Long quoteCount(Merchant merchant) {
        return 100L;
    }
}
