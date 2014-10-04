package au.com.iglooit.hellscream.service.statistic;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 4/10/2014
 * Time: 12:06 PM
 */
public interface StatisticService {
    Integer quoteCount();
    Integer merchantCount();
    Integer feedbackCount();
    Integer msgCount();
    Integer quoteCount(IGUser user);
    Integer quoteCount(Merchant merchant);
}
