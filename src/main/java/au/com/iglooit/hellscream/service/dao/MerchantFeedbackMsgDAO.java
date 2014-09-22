package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.MerchantFeedbackMsg;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 22/09/2014
 * Time: 1:28 PM
 */
public interface MerchantFeedbackMsgDAO extends IEntityService<MerchantFeedbackMsg> {
    void createMerchantFeedbackMsg(MerchantFeedbackMsg msg);
    MerchantFeedbackMsg getLatestMsg();
}
