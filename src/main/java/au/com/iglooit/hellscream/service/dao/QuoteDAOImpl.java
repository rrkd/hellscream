package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.model.vo.QuoteVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
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
    private static final Integer PAGE_COUNT = 10;

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
        if (quote.getQuoteTransactions() != null) {
            for (QuoteTransaction quoteTransaction : quote.getQuoteTransactions()) {
                quoteTransaction.getMerchant();
            }
        }
        return quote;
    }

    @Override
    public List<Quote> findQuoteByEmail(String clientUserEmail) {
        Query q = getEntityManager()
                .createQuery("select q from Quote q join fetch q.quoteTransactions " +
                        "where q.clientUserEmail=:clientUserEmail ")
                .setParameter("clientUserEmail", clientUserEmail);
        List<Quote> result = q.getResultList();
        for (Quote quote : result) {
            if (quote.getQuoteTransactions() != null) {
                quote.getQuoteTransactions().size();
            }
        }
        return q.getResultList();
    }

    @Override
    public SearchResultVO<QuoteVO> findQuoteByEmail(String clientUserEmail, Integer page) {
        Integer startPage = page == null ? 1 : page;
        Query q = getEntityManager()
                .createQuery("select q from Quote q join fetch q.quoteTransactions " +
                        "where q.clientUserEmail=:clientUserEmail ")
                .setParameter("clientUserEmail", clientUserEmail)
                .setMaxResults(PAGE_COUNT)
                .setFirstResult((startPage - 1) * PAGE_COUNT);
        Query countQuery = getEntityManager()
                .createQuery("select count(q) from Quote q join fetch q.quoteTransactions " +
                        "where q.clientUserEmail=:clientUserEmail ")
                .setParameter("clientUserEmail", clientUserEmail);
        SearchResultVO<QuoteVO> resultVO = new SearchResultVO<QuoteVO>();

        for (Quote qt : (List<Quote>) q.getResultList()) {
            resultVO.getVoList().add(new QuoteVO(qt));
        }
        resultVO.setPageNum(startPage);
        resultVO.setTotal(((Long) countQuery.getSingleResult()).intValue() / PAGE_COUNT + 1);
        return resultVO;
    }

    @Override
    public Long countQuote() {
        Query q = getEntityManager()
                .createQuery("select count(q) from Quote q ");
        return (Long)q.getSingleResult();
    }

    @Override
    public List<Quote> findQuoteByDate(Date startDate, Date endDate) {
        Query q = getEntityManager()
                .createQuery("select q from Quote q " +
                        "where q.postDate>=:startDate and q.postDate<=:endDate " +
                        "order by q.postDate desc")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate);
        return q.getResultList();
    }
}
