package au.com.iglooit.hellscream.service.feedback;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.MerchantFeedbackMsg;
import au.com.iglooit.hellscream.model.vo.MerchantFeedbackMsgVO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.dao.MerchantFeedbackMsgDAO;
import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 24/09/2014
 * Time: 6:09 AM
 */
@Component
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private MerchantFeedbackMsgDAO merchantFeedbackMsgDAO;
    @Resource
    private MerchantDAO merchantDAO;

    @Override
    public List<MerchantFeedbackMsgVO> findFeedbackForMerchant(Key merchantKey, Integer size) {
        List<MerchantFeedbackMsg> feedbackMsgList = merchantFeedbackMsgDAO.findFeedbackMsg(merchantKey, size);
        return convertToVO(feedbackMsgList);
    }

    private List<MerchantFeedbackMsgVO> convertToVO(List<MerchantFeedbackMsg> msgList) {
        List<MerchantFeedbackMsgVO> result = new ArrayList<>();
        for (MerchantFeedbackMsg msg : msgList) {
            MerchantFeedbackMsgVO vo = new MerchantFeedbackMsgVO();
            vo.setComment(msg.getComment());
            vo.setUserEmail(msg.getUserEmail());
            vo.setUserName(msg.getUserName());
            vo.setPostDate(msg.getCreatedOn());
            vo.setRank(msg.getRank());
            Merchant merchant = merchantDAO.findByKey(msg.getMerchantKey());
            if (merchant != null) {
                vo.setMerchantTradeName(merchant.getTradeName());
                vo.setMerchantUrl(merchant.getCanonicalSlugId());
            }
            result.add(vo);

        }
        return result;
    }
}


