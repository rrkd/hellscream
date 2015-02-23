package au.com.iglooit.hellscream.aop;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.UserStatistic;
import au.com.iglooit.hellscream.service.dao.UserStatisticDAO;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by nicholaszhu on 21/02/2015.
 */
@Aspect
@Component
public class UserStatisticAspect {
    private static final Logger LOG = LoggerFactory.getLogger(UserStatisticAspect.class);
    @Resource
    private UserStatisticDAO userStatisticDAO;

    @After("execution(* au.com.iglooit.hellscream.service.dao.UserDAO.createUser(..))&& args(user)")
    public void afterCreateUser(IGUser user) {
        LOG.info("parameter is " + user.getEmail());
        // create a new user statistic
        UserStatistic userStatistic = new UserStatistic();
        userStatistic.setEmail(user.getEmail());
        userStatistic.setUserKey(user.getKey());
        userStatistic.setCountQuote(0L);
        userStatistic.setCountFeedback(0L);
        userStatistic.setCountMsg(0L);
        userStatisticDAO.createUserStatistic(userStatistic);
    }

    @After("execution(* au.com.iglooit.hellscream.service.dao.UserDAO.createNormalUser(..))&& args(user)")
    public void afterCreateNormalUser(IGUser user) {
        LOG.info("parameter is " + user.getEmail());
        // create a new user statistic
        UserStatistic userStatistic = new UserStatistic();
        userStatistic.setEmail(user.getEmail());
        userStatistic.setUserKey(user.getKey());
        userStatistic.setCountQuote(0L);
        userStatistic.setCountFeedback(0L);
        userStatistic.setCountMsg(0L);
        userStatisticDAO.createUserStatistic(userStatistic);
    }

    @After("execution(* au.com.iglooit.hellscream.service.dao.UserDAO.signUpAsNewDefaultUser(..))&& args(user)")
    public void signUpAsNewDefaultUser(IGUser user) {
        LOG.info("parameter is " + user.getEmail());
        // create a new user statistic
        UserStatistic userStatistic = new UserStatistic();
        userStatistic.setEmail(user.getEmail());
        userStatistic.setUserKey(user.getKey());
        userStatistic.setCountQuote(0L);
        userStatistic.setCountFeedback(0L);
        userStatistic.setCountMsg(0L);
        userStatisticDAO.createUserStatistic(userStatistic);
    }

    @After("execution(* au.com.iglooit.hellscream.service.dao.QuoteDAO.createQuote(..))&& args(quote)")
    public void afterCreateQuote(Quote quote) {
        UserStatistic userStatistic = userStatisticDAO.findByEmail(quote.getClientUserEmail());
        if(userStatistic != null) {
            userStatistic.setCountQuote(userStatistic.getCountQuote() + 1);
            userStatisticDAO.update(userStatistic);
        }
    }
}
