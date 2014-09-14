package au.com.iglooit.hellscream.model.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 12/09/2014
 * Time: 10:18 AM
 */
public class QuoteMsgVO implements Serializable {
    private String mobile;
    private String userEmail;
    private String userName;
    private String quoteKey;
    private String quoteTitle;

    public QuoteMsgVO() {

    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuoteKey() {
        return quoteKey;
    }

    public void setQuoteKey(String quoteKey) {
        this.quoteKey = quoteKey;
    }

    public String getQuoteTitle() {
        return quoteTitle;
    }

    public void setQuoteTitle(String quoteTitle) {
        this.quoteTitle = quoteTitle;
    }
}
