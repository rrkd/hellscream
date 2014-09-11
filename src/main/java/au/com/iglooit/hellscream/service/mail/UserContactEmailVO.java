package au.com.iglooit.hellscream.service.mail;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 9/09/2014
 * Time: 6:29 PM
 */
public class UserContactEmailVO implements Serializable {
    private IGUser user;
    private QuoteTransaction quoteTransaction;
    private String toAddress;

    public UserContactEmailVO() {

    }

    public IGUser getUser() {
        return user;
    }

    public void setUser(IGUser user) {
        this.user = user;
    }

    public QuoteTransaction getQuoteTransaction() {
        return quoteTransaction;
    }

    public void setQuoteTransaction(QuoteTransaction quoteTransaction) {
        this.quoteTransaction = quoteTransaction;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }
}
