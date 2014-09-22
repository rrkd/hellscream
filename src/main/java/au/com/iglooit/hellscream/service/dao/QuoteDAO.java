package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Quote;
import com.google.appengine.api.datastore.Key;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 2/09/2014
 * Time: 9:20 PM
 */
public interface QuoteDAO extends IEntityService<Quote> {
    void createQuote(Quote quote);
    Quote loadQuote(Key key);
    List<Quote> findQuoteByEmail(String email);
    List<Quote> findQuoteByDate(Date startDate, Date endDate);
}
