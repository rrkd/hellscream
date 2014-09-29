package au.com.iglooit.hellscream.service.mail;

import au.com.iglooit.hellscream.model.entity.Quote;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 7/09/2014
 * Time: 8:36 AM
 */
public class QuoteEmailVO implements Serializable {
    private List<String> toAddressList;
    private String quoteURL;
    private String quoteApplyURL;
    private Quote quote;

    public QuoteEmailVO() {

    }

    public List<String> getToAddressList() {
        return toAddressList;
    }

    public void setToAddressList(List<String> toAddressList) {
        this.toAddressList = toAddressList;
    }

    public String getQuoteURL() {
        return quoteURL;
    }

    public void setQuoteURL(String quoteURL) {
        this.quoteURL = quoteURL;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public String getQuoteApplyURL() {
        return quoteApplyURL;
    }

    public void setQuoteApplyURL(String quoteApplyURL) {
        this.quoteApplyURL = quoteApplyURL;
    }
}
