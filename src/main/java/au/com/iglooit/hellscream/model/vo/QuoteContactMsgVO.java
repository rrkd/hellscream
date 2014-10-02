package au.com.iglooit.hellscream.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 1/10/2014
 * Time: 10:03 PM
 */
public class QuoteContactMsgVO implements Serializable {
    private String quoteTransactionKey;

    private String merchantKey;

    private String title;

    private Date postDate;

    private String userComment;

    private String userKey;

    private String userName;

    private String userPhone;

    private String userEmail;

    private String userForename;

    private String userSurname;

    public QuoteContactMsgVO() {

    }

    public String getQuoteTransactionKey() {
        return quoteTransactionKey;
    }

    public void setQuoteTransactionKey(String quoteTransactionKey) {
        this.quoteTransactionKey = quoteTransactionKey;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserForename() {
        return userForename;
    }

    public void setUserForename(String userForename) {
        this.userForename = userForename;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
}
