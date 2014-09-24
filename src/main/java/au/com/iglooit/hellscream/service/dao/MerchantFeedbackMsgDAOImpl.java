package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.MerchantFeedbackMsg;
import au.com.iglooit.hellscream.repository.BaseRepository;
import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 22/09/2014
 * Time: 1:28 PM
 */
@Repository
@Transactional
public class MerchantFeedbackMsgDAOImpl extends BaseRepository<MerchantFeedbackMsg>
        implements MerchantFeedbackMsgDAO {
    public MerchantFeedbackMsgDAOImpl() {
        super(MerchantFeedbackMsg.class);
    }

    @Override
    public void createMerchantFeedbackMsg(MerchantFeedbackMsg msg) {
        add(msg);
    }

    @Override
    public MerchantFeedbackMsg getLatestMsg() {
        Query q = getEntityManager().createQuery("select c from MerchantFeedbackMsg c order by c.createdOn desc ");
        List<MerchantFeedbackMsg> msgList = q.getResultList();
        return msgList.size() > 0 ? msgList.get(0) : null;
    }

    @Override
    public List<MerchantFeedbackMsg> findFeedbackMsg(Key merchantKey, Integer size) {
        Query q = getEntityManager().createQuery("select c from MerchantFeedbackMsg c " +
                "where c.merchantKey=:merchantKey order by c.createdOn desc ")
                .setParameter("merchantKey", merchantKey);
        if (size != null) {
            q.setMaxResults(size);
        }
        return q.getResultList();
    }
}
