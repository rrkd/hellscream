package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.datastore.Key;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Created by nicholaszhu on 21/02/2015.
 */
@Entity
public class UserStatistic extends NoneGeoIndexEntity {
    public enum UserStatisticField {
        Message, Quote, Feedback
    }

    private String email;
    @Basic
    private Key userKey;
    private Long countQuote;
    private Long countMsg;
    private Long countFeedback;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Key getUserKey() {
        return userKey;
    }

    public void setUserKey(Key userKey) {
        this.userKey = userKey;
    }

    public Long getCountQuote() {
        return countQuote;
    }

    public void setCountQuote(Long countQuote) {
        this.countQuote = countQuote;
    }

    public Long getCountMsg() {
        return countMsg;
    }

    public void setCountMsg(Long countMsg) {
        this.countMsg = countMsg;
    }

    public Long getCountFeedback() {
        return countFeedback;
    }

    public void setCountFeedback(Long countFeedback) {
        this.countFeedback = countFeedback;
    }

    public void setCount(UserStatisticField field, Long count) {
        switch (field){
            case Feedback:
                setCountFeedback(count);
                break;
            case Message:
                setCountMsg(count);
                break;
            case Quote:
                setCountQuote(count);
                break;
            default:
                break;
        }
    }

    public Long getCount(UserStatisticField field){
        switch (field){
            case Feedback:
                return getCountFeedback();
            case Message:
                return getCountMsg();
            case Quote:
                return getCountQuote();
            default:
                return 0L;
        }
    }
}
