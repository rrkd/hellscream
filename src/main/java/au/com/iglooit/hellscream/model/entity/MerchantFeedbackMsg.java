package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.search.Document;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 22/09/2014
 * Time: 11:59 AM
 */
@Entity
public class MerchantFeedbackMsg extends BaseEntity {
    private String userEmail;
    private String userName;
    private String comment;
    private Integer rank;
    @Basic
    private Key merchantKey;

    public MerchantFeedbackMsg() {

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

    public Key getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(Key merchantKey) {
        this.merchantKey = merchantKey;
    }

    @Override
    public Document toFullTextDocument() {
        throw new UnsupportedOperationException("MerchantFeedbackMsg can't support full text search");
    }

    @Override
    public Document toGeoDocument() {
        throw new UnsupportedOperationException("MerchantFeedbackMsg can't support Geo search");
    }
}
