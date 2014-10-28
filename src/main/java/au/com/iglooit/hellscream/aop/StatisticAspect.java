package au.com.iglooit.hellscream.aop;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteFeedbackMsg;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.service.dao.StatisticDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 28/10/2014
 * Time: 11:31 AM
 */
@Aspect
@Component
public class StatisticAspect {
    private static final Logger LOG = LoggerFactory.getLogger(StatisticAspect.class);
    @Resource
    private StatisticDAO statisticDAO;
    @After("execution(* au.com.iglooit.hellscream.service.dao.MerchantDAO.createMerchant(..))&& args(merchant)")
    public void afterCreateMerchant(Merchant merchant) {
            LOG.info("parameter is " + merchant.getTradeName());
            statisticDAO.addMerchant();
    }

    @After("execution(* au.com.iglooit.hellscream.service.dao.QuoteDAO.createQuote(..))&& args(quote)")
    public void afterCreateQuote(Quote quote) {
        statisticDAO.addQuote();
    }

    @After("execution(* au.com.iglooit.hellscream.service.dao.QuoteTransactionDAO.createQuoteTransaction(..)) " +
            "&& args(quoteTransaction)")
    public void afterCreateQuoteTransaction(QuoteTransaction quoteTransaction) {
        statisticDAO.addQuoteTransaction();
    }

    @After("execution(* au.com.iglooit.hellscream.service.dao.QuoteFeedbackMsgDAO.createFeebackMsg(..)) " +
            "&& args(quoteFeedbackMsg)")
    public void afterCreateQuoteTransaction(QuoteFeedbackMsg quoteFeedbackMsg) {
        statisticDAO.addQuoteFeedbackMsg();
    }


}
