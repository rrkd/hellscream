package au.com.iglooit.hellscream.service.quote;

import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteStatus;
import au.com.iglooit.hellscream.model.vo.QuoteVO;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.service.dao.QuoteManageService;
import au.com.iglooit.hellscream.service.mail.EMailService;
import au.com.iglooit.hellscream.service.mail.QuoteEmailVO;
import au.com.iglooit.hellscream.service.search.SuggestMerchantService;
import au.com.iglooit.hellscream.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private QuoteManageService quoteManageService;
    @Resource
    private SuggestMerchantService suggestMerchantService;
    @Resource
    private EMailService eMailService;

    @Override
    public Map<String, List<Quote>> loadUserQuoteList(String email) {

        List<Quote> quoteList = quoteManageService.findQuoteByEmail(email);
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
        WebProperties webProperties = WebProperties.getInstance();
        String host = webProperties.get("host");
        String quoteUrl = webProperties.get("quote.add.transaction.url");

        // get merchant email list
        List<String> emailList = suggestMerchantService.quoteMerchantEmail(quote);
        // create quote
        quote.setSendEmailList(emailList);
        quoteManageService.createQuote(quote);
        // send email
        QuoteEmailVO vo = new QuoteEmailVO();
        vo.setQuoteURL(host + quoteUrl + quote.getKeyString());
        vo.setToAddressList(emailList);
        eMailService.sendQuoteEmail(vo);
    }

    @Override
    public List<QuoteVO> latestQuoteList() {
        List<Quote> quoteList = quoteManageService.findQuoteByDate(DateUtils.getOneWeekAgo(), DateUtils.getNow());
        List<QuoteVO> result = new ArrayList<>();
        int len = quoteList.size() > LATEST_QUOTE ? LATEST_QUOTE : quoteList.size();
        for (int i = 0; i < len; i++) {
            result.add(new QuoteVO(quoteList.get(i)));
        }
        return result;
    }
}
