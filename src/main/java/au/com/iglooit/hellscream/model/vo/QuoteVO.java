package au.com.iglooit.hellscream.model.vo;

import au.com.iglooit.hellscream.model.entity.Quote;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 14/09/2014
 * Time: 10:38 PM
 */
public class QuoteVO implements Serializable {
    private String key;
    private String title;
    private Date postDate;

    public QuoteVO() {

    }

    public QuoteVO(Quote quote) {
        convertFromQuote(quote);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public void convertFromQuote(Quote quote) {
        this.title = quote.getTitle();
        this.key = quote.getKeyString();
        this.postDate = quote.getPostDate();
    }

}
