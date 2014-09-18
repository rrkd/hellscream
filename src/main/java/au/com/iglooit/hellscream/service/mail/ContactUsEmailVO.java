package au.com.iglooit.hellscream.service.mail;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 16/09/2014
 * Time: 1:28 PM
 */
public class ContactUsEmailVO implements Serializable {
    private String userEmail;
    private String name;
    private String content;

    public ContactUsEmailVO() {

    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
