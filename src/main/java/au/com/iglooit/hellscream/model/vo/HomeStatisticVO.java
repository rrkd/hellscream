package au.com.iglooit.hellscream.model.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 4/10/2014
 * Time: 1:46 PM
 */
public class HomeStatisticVO implements Serializable {
    private Long quoteCount;
    private Long merchantCount;
    private Long feedbackCount;
    private Long msgCount;

    public HomeStatisticVO() {

    }

    public Long getQuoteCount() {
        return quoteCount;
    }

    public void setQuoteCount(Long quoteCount) {
        this.quoteCount = quoteCount;
    }

    public Long getMerchantCount() {
        return merchantCount;
    }

    public void setMerchantCount(Long merchantCount) {
        this.merchantCount = merchantCount;
    }

    public Long getFeedbackCount() {
        return feedbackCount;
    }

    public void setFeedbackCount(Long feedbackCount) {
        this.feedbackCount = feedbackCount;
    }

    public Long getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(Long msgCount) {
        this.msgCount = msgCount;
    }
}
