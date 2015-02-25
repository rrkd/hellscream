package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.datastore.Key;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class QuotePostMsg extends NoneGeoIndexEntity {
    public enum Status{
        Read, Unread
    }
    @Basic
    private Key quoteKey;
    @Basic
    private Key merchantKey;
    private Status status;

    public Key getQuoteKey() {
        return quoteKey;
    }

    public void setQuoteKey(Key quoteKey) {
        this.quoteKey = quoteKey;
    }

    public Key getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(Key merchantKey) {
        this.merchantKey = merchantKey;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
