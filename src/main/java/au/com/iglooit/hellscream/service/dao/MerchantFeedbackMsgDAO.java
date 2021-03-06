package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.MerchantFeedbackMsg;
import com.google.appengine.api.datastore.Key;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 22/09/2014
 * Time: 1:28 PM
 */
public interface MerchantFeedbackMsgDAO extends IEntityService<MerchantFeedbackMsg> {
    void createMerchantFeedbackMsg(MerchantFeedbackMsg msg);
    MerchantFeedbackMsg getLatestMsg();
    List<MerchantFeedbackMsg> findFeedbackMsg(Key merchantKey, Integer size);
    Long countMerchantFeedback();
}
