package au.com.iglooit.hellscream.service.quote;

import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteStatus;
import au.com.iglooit.hellscream.service.dao.QuoteManageService;
import com.google.appengine.repackaged.com.google.common.collect.ImmutableMap;
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

    @Resource
    private QuoteManageService quoteManageService;

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
}
