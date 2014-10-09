package au.com.iglooit.hellscream.model.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 8/10/2014
 * Time: 1:15 PM
 */
public class LoginVO implements Serializable {
    private String username;
    private String password;

    public LoginVO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
