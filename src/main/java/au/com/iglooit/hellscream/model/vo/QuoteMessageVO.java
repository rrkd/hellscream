package au.com.iglooit.hellscream.model.vo;

import au.com.iglooit.hellscream.model.entity.Quote;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 10/09/2014
 * Time: 9:26 AM
 */
public class QuoteMessageVO implements Serializable {
    private String userName;
    private String quoteTitle;
    private String quoteKey;
    private String userEmail;
    private String mobile;

    public QuoteMessageVO() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuoteTitle() {
        return quoteTitle;
    }

    public void setQuoteTitle(String quoteTitle) {
        this.quoteTitle = quoteTitle;
    }

    public String getQuoteKey() {
        return quoteKey;
    }

    public void setQuoteKey(String quoteKey) {
        this.quoteKey = quoteKey;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
