package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.repository.BaseRepository;
import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 2/09/2014
 * Time: 9:20 PM
 */
@Repository
@Transactional
public class QuoteDAOImpl extends BaseRepository<Quote> implements QuoteDAO {
    public QuoteDAOImpl() {
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

    @Override
    public List<Quote> findQuoteByDate(Date startDate, Date endDate) {
        Query q = getEntityManager()
                .createQuery("select q from Quote q join fetch q.quoteTransactions " +
                        "where q.postDate>=:startDate and q.postDate<=:endDate " +
                        "order by q.postDate desc")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate);
        return q.getResultList();
    }
}
