package au.com.iglooit.hellscream.service.quote;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteStatus;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.model.entity.QuoteTransactionStatus;
import au.com.iglooit.hellscream.model.vo.QuoteMsgVO;
import au.com.iglooit.hellscream.service.dao.QuoteDAO;
import au.com.iglooit.hellscream.service.dao.QuoteTransactionDAO;
import au.com.iglooit.hellscream.service.dao.UserDAO;
import au.com.iglooit.hellscream.service.mail.EMailService;
import au.com.iglooit.hellscream.service.mail.UserContactEmailVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 10/09/2014
 * Time: 6:17 AM
 */
@Component
public class QuoteTransactionServiceImpl implements QuoteTransactionService {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteTransactionServiceImpl.class);
    @Resource
    private QuoteTransactionDAO quoteTransactionDAO;
    @Resource
    private QuoteDAO quoteDAO;
    @Resource
    private UserDAO userDAO;
    @Resource
    private EMailService eMailService;
    @Override
    public List<QuoteMsgVO> findLatestMessage(Merchant merchant) {
        List<QuoteMsgVO> voList = new ArrayList<>();
        List<QuoteTransaction> quoteTransactionList = quoteTransactionDAO.findQuoteTransactionByMerchant(merchant, 10);
        for(QuoteTransaction quoteTransaction : quoteTransactionList) {
            QuoteMsgVO vo = new QuoteMsgVO();
            IGUser user = userDAO.findByEmail(quoteTransaction.getQuote().getClientUserEmail());
            if (user == null) {
                LOG.error("User of quote does not exist.");
                continue;
            }
            vo.setMobile(user.getMobile());
            vo.setUserEmail(user.getEmail());
            vo.setUserName(user.getNickname());
            vo.setQuoteKey(quoteTransaction.getQuote().getKeyString());
            vo.setQuoteTitle(quoteTransaction.getQuote().getTitle());
        }
        return voList;
    }

    @Override
    public void contactMerchant(QuoteTransaction quoteTransaction) {
        // change quote status
        Quote quote = quoteTransaction.getQuote();
        quoteTransaction.getQuote().setStatus(QuoteStatus.Contacting);
        quoteTransaction.setQuoteTransactionStatus(QuoteTransactionStatus.Contacting);
        quoteDAO.update(quote);
        // send email
        UserContactEmailVO vo = new UserContactEmailVO();
        vo.setQuoteTransaction(quoteTransaction);
        vo.setToAddress(quoteTransaction.getMerchant().getEmail());
        IGUser user = userDAO.findByEmail(quote.getClientUserEmail());
        vo.setUser(user);
        eMailService.sendUserContactEmail(vo);
    }
}
