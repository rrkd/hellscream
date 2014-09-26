package au.com.iglooit.hellscream.service.queue;

import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.service.dao.QuoteDAO;
import au.com.iglooit.hellscream.service.mail.EMailService;
import au.com.iglooit.hellscream.service.mail.QuoteEmailVO;
import au.com.iglooit.hellscream.service.search.SuggestMerchantService;
import com.google.appengine.api.datastore.KeyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 26/09/2014
 * Time: 8:14 AM
 */
@Controller
public class QuoteQueue {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteQueue.class);
    public static final String QUOTE_QUEUE_URL = "/pq/quote/";
    public static final String QUOTE_QUEUE_NAME = "quote_queue";
    @Resource
    private EMailService eMailService;
    @Resource
    private QuoteDAO quoteDAO;
    @Resource
    private SuggestMerchantService suggestMerchantService;

    @RequestMapping(value = QUOTE_QUEUE_URL,
            method = RequestMethod.POST)
    public ResponseEntity QuoteHandler(@RequestParam("keyString") String quoteKey) {
        WebProperties webProperties = WebProperties.getInstance();
        String host = webProperties.get("host");
        String quoteUrl = webProperties.get("quote.add.transaction.url");

        assert quoteKey != null;
        LOG.info("Hand quote message for " + quoteKey);
        Quote quote = quoteDAO.findByKey(KeyFactory.stringToKey(quoteKey));
        // get merchant email list
        List<String> emailList = suggestMerchantService.quoteMerchantEmail(quote);
        // create quote
        quote.setSendEmailList(emailList);
        quoteDAO.update(quote);
        // send email
        QuoteEmailVO vo = new QuoteEmailVO();
        vo.setQuoteURL(host + quoteUrl + quote.getKeyString());
        vo.setToAddressList(emailList);
        eMailService.sendQuoteEmail(vo);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
