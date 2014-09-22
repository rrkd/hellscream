package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.QuoteFeedbackMsg;
import au.com.iglooit.hellscream.repository.BaseRepository;
import au.com.iglooit.hellscream.utils.DateUtils;
import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 14/09/2014
 * Time: 2:00 PM
 */
@Repository
@Transactional
public class QuoteFeedbackMsgDAOImpl extends BaseRepository<QuoteFeedbackMsg>
        implements QuoteFeedbackMsgDAO {
    public QuoteFeedbackMsgDAOImpl() {
        super(QuoteFeedbackMsg.class);
    }

    @Override
    public QuoteFeedbackMsg getLatestQuoteFeedbackMsg() {
        Query q = getEntityManager()
                .createQuery("select q from QuoteFeedbackMsg q " +
                        "order by q.createdOn desc").setMaxResults(1);
        List<QuoteFeedbackMsg> msgList = q.getResultList();
        return msgList.size() <= 0 ? null : msgList.get(0);
    }

    @Override
    public void createFeebackMsg(QuoteFeedbackMsg quoteFeedbackMsg) {
        quoteFeedbackMsg.setCreatedOn(DateUtils.getNow());
        add(quoteFeedbackMsg);
    }

    @Override
    public List<QuoteFeedbackMsg> findByMerchant(Key merchantKey) {
        Query q = getEntityManager()
                .createQuery("select q from QuoteFeedbackMsg q " +
                        "where q.quoteTransactionKey=:merchantKey " +
                        "order by q.createdOn desc")
                .setParameter("merchantKey", merchantKey);
        return q.getResultList();
    }
}
