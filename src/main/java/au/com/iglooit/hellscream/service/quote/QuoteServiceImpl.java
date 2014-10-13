package au.com.iglooit.hellscream.service.quote;

import au.com.iglooit.hellscream.controller.QuoteController;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.model.vo.QuoteTransactionVO;
import au.com.iglooit.hellscream.model.vo.QuoteVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.dao.QuoteDAO;
import au.com.iglooit.hellscream.service.dao.QuoteTransactionDAO;
import au.com.iglooit.hellscream.service.mail.EMailService;
import au.com.iglooit.hellscream.service.mail.QuoteEmailVO;
import au.com.iglooit.hellscream.service.queue.QuoteQueue;
import au.com.iglooit.hellscream.service.search.SuggestMerchantService;
import au.com.iglooit.hellscream.utils.DateUtils;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.google.appengine.api.taskqueue.TaskOptions.Builder.withUrl;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 6/09/2014
 * Time: 2:09 PM
 */
@Component
public class QuoteServiceImpl implements QuoteService {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteServiceImpl.class);
    private static final Integer LATEST_QUOTE = 10;

    @Resource
    private QuoteDAO quoteDAO;
    @Resource
    private SuggestMerchantService suggestMerchantService;
    @Resource
    private EMailService eMailService;
    @Resource
    private QuoteTransactionDAO quoteTransactionDAO;
    @Resource
    private MerchantDAO merchantDAO;

    @Override
    public List<Quote> loadUserQuoteList(String email) {

        List<Quote> quoteList = quoteDAO.findQuoteByEmail(email);
        LOG.info("[HellScream] find quote list: " + quoteList.size() + " by " + email);
        return quoteList;
    }

    @Override
    public void createQuote(Quote quote) {
        quoteDAO.createQuote(quote);
        // put into the queue
        Queue queue = QueueFactory.getQueue(QuoteQueue.QUOTE_QUEUE_NAME);
        queue.add(withUrl(QuoteQueue.QUOTE_QUEUE_URL).param("keyString", quote.getKeyString()));
    }

    @Override
    public void createMerchantQuote(Quote quote, Merchant merchant) {
        WebProperties webProperties = WebProperties.getInstance();
        String host = webProperties.get("host");
        quoteDAO.createQuote(quote);
        // get merchant email list
        List<String> emailList = new ArrayList<>();
        emailList.add(merchant.getEmail());
        // create quote
        quote.setSendEmailList(emailList);
        quoteDAO.update(quote);
        // send email
        QuoteEmailVO vo = new QuoteEmailVO();
        vo.setQuoteApplyURL(host + QuoteController.QUOTE_MERCHANT_QUERY_URL + quote.getKeyString());
        vo.setQuoteApplyURL(host + QuoteController.QUOTE_TRANSACTION_URL + quote.getKeyString());
        vo.setToAddressList(emailList);
        vo.setQuote(quote);
        eMailService.sendQuoteEmail(vo);

        merchant.setQuoteCount(merchant.getQuoteCount() + 1);
        merchantDAO.update(merchant);
    }

    @Override
    public List<QuoteVO> latestQuoteList() {
        List<Quote> quoteList = quoteDAO.findQuoteByDate(DateUtils.getOneMonthAgo(), DateUtils.getNow());
        List<QuoteVO> result = new ArrayList<>();
        int len = quoteList.size() > LATEST_QUOTE ? LATEST_QUOTE : quoteList.size();
        for (int i = 0; i < len; i++) {
            result.add(new QuoteVO(quoteList.get(i)));
        }
        return result;
    }

    @Override
    public SearchResultVO<QuoteTransactionVO> findQuoteTransactionByMerchant(Merchant merchant, Integer page) {
        SearchResultVO<QuoteTransaction> transactionList =
                quoteTransactionDAO.findQuoteTransactionByMerchant(merchant, 1);
        SearchResultVO<QuoteTransactionVO> searchResultVO = new SearchResultVO<>();
        searchResultVO.setPageNum(transactionList.getPageNum());
        searchResultVO.setTotal(transactionList.getTotal());
        for (QuoteTransaction qt : transactionList.getVoList()) {
            searchResultVO.getVoList().add(new QuoteTransactionVO(qt));
        }
        return searchResultVO;
    }

    @Override
    public SearchResultVO<QuoteVO> loadUserQuoteList(String email, Integer page) {
        return quoteDAO.findQuoteByEmail(email, page);
    }

    @Override
    public SearchResultVO<QuoteVO> loadLatestUserQuoteList(String email) {
        return quoteDAO.findQuoteByEmail(email, 1);
    }
}
