package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.repository.BaseRepository;
import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 2/09/2014
 * Time: 9:20 PM
 */
@Repository
@Transactional
public class QuoteManageServiceImpl extends BaseRepository<Quote> implements QuoteManageService {
    public QuoteManageServiceImpl() {
        super(Quote.class);
    }

    @Override
    public void createQuote(Quote quote) {
        add(quote);
    }

    @Override
    public Quote loadQuote(Key key) {
        Quote quote = findByKey(key);
        for(QuoteTransaction quoteTransaction : quote.getQuoteTransactions()) {
            quoteTransaction.getMerchant();
        }
        return quote;
    }

    @Override
    public List<Quote> findQuoteByEmail(String clientUserEmail) {
        Query q = getEntityManager()
                .createQuery("select q from Quote q join fetch q.quoteTransactions " +
                        "where q.clientUserEmail=:clientUserEmail ")
                .setParameter("clientUserEmail", clientUserEmail);
        return q.getResultList();
    }
}
