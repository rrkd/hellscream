package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.search.Document;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 14/09/2014
 * Time: 1:54 PM
 */
@Entity
public class QuoteFeedbackMsg extends BaseEntity {
    @Basic
    private Key quoteTransactionKey;
    private String comment;
    private Integer rank;

    public Key getQuoteTransactionKey() {
        return quoteTransactionKey;
    }

    public void setQuoteTransactionKey(Key quoteTransactionKey) {
        this.quoteTransactionKey = quoteTransactionKey;
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

    @Override
    public Document toFullTextDocument() {
        throw new UnsupportedOperationException("QuoteFeedbackMsg can't support full text search");
    }

    @Override
    public Document toGeoDocument() {
        throw new UnsupportedOperationException("QuoteFeedbackMsg can't support Geo search");
    }
}
