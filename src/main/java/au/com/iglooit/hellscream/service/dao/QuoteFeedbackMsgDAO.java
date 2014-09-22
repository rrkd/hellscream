package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.QuoteFeedbackMsg;
import com.google.appengine.api.datastore.Key;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 14/09/2014
 * Time: 1:59 PM
 */
public interface QuoteFeedbackMsgDAO extends IEntityService<QuoteFeedbackMsg>{
    QuoteFeedbackMsg getLatestQuoteFeedbackMsg();
    void createFeebackMsg(QuoteFeedbackMsg quoteFeedbackMsg);
    List<QuoteFeedbackMsg> findByMerchant(Key key);
}
