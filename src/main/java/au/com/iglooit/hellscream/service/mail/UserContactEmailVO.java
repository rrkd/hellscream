package au.com.iglooit.hellscream.service.mail;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Quote;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 9/09/2014
 * Time: 6:29 PM
 */
public class UserContactEmailVO implements Serializable {
    private IGUser user;
    private Quote quote;

    public IGUser getUser() {
        return user;
    }

    public void setUser(IGUser user) {
        this.user = user;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
