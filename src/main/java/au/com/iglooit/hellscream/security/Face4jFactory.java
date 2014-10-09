package au.com.iglooit.hellscream.security;

import com.face4j.facebook.Client;
import com.face4j.facebook.enums.HttpClientType;
import com.face4j.facebook.factory.FacebookFactory;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 7/10/2014
 * Time: 8:41 PM
 */
public class Face4jFactory {
    private static Face4jFactory instance = null;
    private static final String clientId = "1510415335869856";
    private static final String clientSecret = "939c0ee6ff0a7e48f9755edea4212ad0";
    private FacebookFactory facebookFactory;

    protected Face4jFactory() {
        Client client = new Client(clientId, clientSecret);
        facebookFactory = new FacebookFactory(client, HttpClientType.URL_FETCH_SERVICE);
    }

    public static Face4jFactory getInstance() {
        if (instance == null) {
            instance = new Face4jFactory();
        }
        return instance;
    }

    public FacebookFactory getFacebookFactory() {
        return facebookFactory;
    }

    public void setFacebookFactory(FacebookFactory facebookFactory) {
        this.facebookFactory = facebookFactory;
    }
}
