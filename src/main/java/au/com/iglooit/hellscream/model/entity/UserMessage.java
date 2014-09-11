package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.search.Document;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 11/09/2014
 * Time: 2:14 PM
 */
@Entity
public class UserMessage extends BaseEntity {
    private String from;
    private String content;
    private Key userKey;

    public UserMessage() {

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Key getUserKey() {
        return userKey;
    }

    public void setUserKey(Key userKey) {
        this.userKey = userKey;
    }

    @Override
    public Document toFullTextDocument() {
        throw new UnsupportedOperationException("UserMessage can't support full text search");
    }

    @Override
    public Document toGeoDocument() {
        throw new UnsupportedOperationException("UserMessage can't support Geo search");
    }
}
