package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.search.Document;
import com.google.appengine.datanucleus.annotations.Unowned;

import javax.persistence.Basic;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 1/10/2014
 * Time: 3:17 PM
 */
@Entity
public class QuoteContactMsg extends BaseEntity {
    @Basic
    private Key quoteTransactionKey;
    @Basic
    private Key merchantKey;

    private Date postDate;

    private String userComment;

    public QuoteContactMsg() {

    }

    public QuoteContactMsg(QuoteTransaction quoteTransaction) {
        this.quoteTransactionKey = quoteTransaction.getKey();
        this.merchantKey = quoteTransaction.getMerchant().getKey();
        this.postDate = quoteTransaction.getCreatedOn();
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public Key getQuoteTransactionKey() {
        return quoteTransactionKey;
    }

    public void setQuoteTransactionKey(Key quoteTransactionKey) {
        this.quoteTransactionKey = quoteTransactionKey;
    }

    public Key getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(Key merchantKey) {
        this.merchantKey = merchantKey;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public Document toFullTextDocument() {
        throw new UnsupportedOperationException("QuoteContactMsg can't support full text search");
    }

    @Override
    public Document toGeoDocument() {
        throw new UnsupportedOperationException("QuoteContactMsg can't support Geo search");
    }
}
