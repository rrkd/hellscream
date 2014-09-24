package au.com.iglooit.hellscream.service.feedback;

import au.com.iglooit.hellscream.model.vo.MerchantFeedbackMsgVO;
import com.google.appengine.api.datastore.Key;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 24/09/2014
 * Time: 6:08 AM
 */
public interface FeedbackService {
    List<MerchantFeedbackMsgVO> findFeedbackForMerchant(Key merchantKey, Integer size);
}
