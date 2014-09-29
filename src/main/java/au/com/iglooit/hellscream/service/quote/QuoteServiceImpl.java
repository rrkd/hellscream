package au.com.iglooit.hellscream.service.quote;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteStatus;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.model.vo.QuoteTransactionVO;
import au.com.iglooit.hellscream.model.vo.QuoteVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import au.com.iglooit.hellscream.service.dao.QuoteDAO;
import au.com.iglooit.hellscream.service.dao.QuoteTransactionDAO;
import au.com.iglooit.hellscream.service.mail.EMailService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, List<Quote>> loadUserQuoteList(String email) {

        List<Quote> quoteList = quoteDAO.findQuoteByEmail(email);
        LOG.info("[nick] find quote list: " + quoteList.size() + " by " + email);
        Map<String, List<Quote>> builder = new HashMap<>();
        builder.put(QuoteStatus.Contacting.name(), new ArrayList<Quote>());
        builder.put(QuoteStatus.Feedback.name(), new ArrayList<Quote>());
        builder.put(QuoteStatus.Quoting.name(), new ArrayList<Quote>());

        for (Quote quote : quoteList) {
            builder.get(quote.getStatus().name()).add(quote);
        }
        return builder;
    }

    @Override
    public void createQuote(Quote quote) {
        quoteDAO.createQuote(quote);
        // put into the queue
        Queue queue = QueueFactory.getQueue(QuoteQueue.QUOTE_QUEUE_NAME);
        queue.add(withUrl(QuoteQueue.QUOTE_QUEUE_URL).param("keyString", quote.getKeyString()));
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
        for(QuoteTransaction qt : transactionList.getVoList()) {
            searchResultVO.getVoList().add(new QuoteTransactionVO(qt));
        }
        return searchResultVO;
    }
}
