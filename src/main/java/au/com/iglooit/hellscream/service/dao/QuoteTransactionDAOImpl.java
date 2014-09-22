package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.repository.BaseRepository;
import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 3/09/2014
 * Time: 2:05 PM
 */
@Repository
@Transactional
public class QuoteTransactionDAOImpl extends BaseRepository<QuoteTransaction>
        implements QuoteTransactionDAO {
    public QuoteTransactionDAOImpl() {
        super(QuoteTransaction.class);
    }

    @Override
    public void createQuoteTransaction(QuoteTransaction quoteTransaction) {
        add(quoteTransaction);
    }

    @Override
    public List<QuoteTransaction> findQuoteTransactionByMerchant(Merchant merchant, Integer limit) {
        List<QuoteTransaction> result = new ArrayList<>();
        Query q = getEntityManager()
                .createQuery("select qt from QuoteTransaction qt " +
                        "join fetch qt.merchant m " +
                        "join fetch qt.quote q " +
                        "where qt.merchant=:merchant ")
                .setParameter("merchant", merchant).setMaxResults(limit);
        result = q.getResultList();
        return result;
    }

    @Override
    public QuoteTransaction findByKey(Key key) {

        Query q = getEntityManager()
                .createQuery("select q from Quote q " +
                        "where q.key = :qkey ")
                .setParameter("qkey", key.getParent());
        List<Quote> quoteList = q.getResultList();
        if (quoteList.size() <= 0) {
            throw new AppX("can't find parent quote for " + key.toString());
        }
        Quote quote = quoteList.get(0);
        for (QuoteTransaction qt : quote.getQuoteTransactions()) {
            if (qt.getKey().getId() == key.getId()) {
                qt.getQuote();
                qt.getMerchant();
                return qt;
            }
        }
        return null;
    }
}
