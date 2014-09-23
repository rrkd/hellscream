package au.com.iglooit.hellscream.model.vo;

import au.com.iglooit.hellscream.model.entity.Merchant;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 23/09/2014
 * Time: 8:39 AM
 */
public class MerchantVO implements Serializable {
    private Merchant merchant;
    private Integer feedbackCount = 0;
    private Integer rank = 3;
    private Integer quoteCount = 0;

    public MerchantVO() {
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Integer getFeedbackCount() {
        return feedbackCount;
    }

    public void setFeedbackCount(Integer feedbackCount) {
        this.feedbackCount = feedbackCount;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getQuoteCount() {
        return quoteCount;
    }

    public void setQuoteCount(Integer quoteCount) {
        this.quoteCount = quoteCount;
    }
}
