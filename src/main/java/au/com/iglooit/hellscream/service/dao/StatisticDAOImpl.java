package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.*;
import au.com.iglooit.hellscream.repository.BaseRepository;
import au.com.iglooit.hellscream.utils.DateUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 28/10/2014
 * Time: 11:08 AM
 */
@Repository
@Transactional
public class StatisticDAOImpl extends BaseRepository<Statistic> implements StatisticDAO {
    public StatisticDAOImpl() {
        super(Statistic.class);
    }

    @Override
    public void createStatistic(Statistic statistic) {
        add(statistic);
    }

    @Override
    public Statistic findByName(String name) {
        Query q = getEntityManager()
                .createQuery("select q from Statistic q " +
                        "where q.statisticName=:statisticName ")
                .setParameter("statisticName", name);
        List<Statistic> result = q.getResultList();
        if (result.size() <= 0) {
            return null;
        } else {
            return result.get(0);
        }
    }

    @Override
    public void addMerchant() {
        addClass(Merchant.class);
    }

    @Override
    public Long countMerchant() {
        return countClass(Merchant.class);
    }

    @Override
    public void addQuote() {
        addClass(Quote.class);
    }

    @Override
    public Long countQuote() {
        return countClass(Quote.class);
    }

    @Override
    public void addQuoteTransaction() {
        addClass(QuoteTransaction.class);
    }

    @Override
    public Long countQuoteTransaction() {
        return countClass(QuoteTransaction.class);
    }

    @Override
    public void addQuoteFeedbackMsg() {
        addClass(QuoteFeedbackMsg.class);
    }

    @Override
    public Long countQuoteFeedbackMsg() {
        return countClass(QuoteFeedbackMsg.class);
    }

    @Override
    public void addSuburb() {
        addClass(Suburb.class);
    }

    @Override
    public Long countSuburb() {
        return countClass(Suburb.class);
    }

    @Override
    public void addInitMerchant() {
        addClass(InitMerchant.class);
    }

    @Override
    public Long countInitMerchant() {
        return countClass(InitMerchant.class);
    }

    private void addClass(Class clazz) {
        Query q = getEntityManager()
                .createQuery("select q from Statistic q " +
                        "where q.statisticName=:statisticName ")
                .setParameter("statisticName", clazz.getName());
        List<Statistic> result = q.getResultList();
        if (result.size() <= 0) {
            throw new UnsupportedClassVersionError("Class " + clazz.getName() + " has not been supported");
        } else {
            Statistic statistic = result.get(0);
            statistic.setStatisticCount(statistic.getStatisticCount() + 1);
            statistic.setUpdateDate(DateUtils.getNow());
            update(statistic);
        }
    }

    private Long countClass(Class clazz) {
        Query q = getEntityManager()
                .createQuery("select q from Statistic q " +
                        "where q.statisticName=:statisticName ")
                .setParameter("statisticName", clazz.getName());
        if (q.getResultList().size() <= 0) {
            return 0L;
        }
        Statistic statistic = (Statistic) q.getResultList().get(0);
        return statistic.getStatisticCount();
    }
}
