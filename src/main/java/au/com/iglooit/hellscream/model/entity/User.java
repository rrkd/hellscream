package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.search.Document;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 7/04/2014
 * Time: 10:03 PM
 */
@Entity
public class User extends BaseEntity
{
    private String username;
    private String nikeName;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Document toDocument() {
        throw new UnsupportedOperationException("User can't support full text search");
    }
}
