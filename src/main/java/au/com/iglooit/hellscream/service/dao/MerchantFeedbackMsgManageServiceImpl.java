package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.MerchantFeedbackMsg;
import au.com.iglooit.hellscream.repository.BaseRepository;
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
public class MerchantFeedbackMsgManageServiceImpl extends BaseRepository<MerchantFeedbackMsg>
        implements MerchantFeedbackMsgManageService {
    public MerchantFeedbackMsgManageServiceImpl() {
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
}
