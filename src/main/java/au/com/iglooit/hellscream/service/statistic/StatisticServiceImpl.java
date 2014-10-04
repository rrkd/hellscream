package au.com.iglooit.hellscream.service.statistic;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 4/10/2014
 * Time: 12:07 PM
 */
@Component
public class StatisticServiceImpl implements StatisticService {
    @Override
    public Integer quoteCount() {
        return 100;
    }

    @Override
    public Integer merchantCount() {
        return 100;
    }

    @Override
    public Integer feedbackCount() {
        return 100;
    }

    @Override
    public Integer msgCount() {
        return 100;
    }

    @Override
    public Integer quoteCount(IGUser user) {
        return 100;
    }

    @Override
    public Integer quoteCount(Merchant merchant) {
        return 100;
    }
}
