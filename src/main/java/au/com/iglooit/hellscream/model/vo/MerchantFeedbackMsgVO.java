package au.com.iglooit.hellscream.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 22/09/2014
 * Time: 2:58 PM
 */
public class MerchantFeedbackMsgVO implements Serializable {
    private String merchantUrl;
    private String merchantTradeName;
    private String userName;
    private String userEmail;
    private Date postDate;
    private String comment;
    private Integer rank;

    public MerchantFeedbackMsgVO() {

    }

    public String getMerchantUrl() {
        return merchantUrl;
    }

    public void setMerchantUrl(String merchantUrl) {
        this.merchantUrl = merchantUrl;
    }

    public String getMerchantTradeName() {
        return merchantTradeName;
    }

    public void setMerchantTradeName(String merchantTradeName) {
        this.merchantTradeName = merchantTradeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
