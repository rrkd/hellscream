package au.com.iglooit.hellscream.model.vo;

import au.com.iglooit.hellscream.model.entity.Suburb;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 25/09/2014
 * Time: 1:32 PM
 */
public class SuburbVO implements Serializable {
    private String id;
    private String postCode;
    private String text;
    private String keyString;

    public SuburbVO() {

    }

    public SuburbVO(Suburb suburb) {
        this.id = suburb.getCanonicalSlugId();
        this.text = suburb.getName() + " - " + suburb.getPostCode() + " (" + suburb.getState() + ")";
        this.postCode = suburb.getPostCode();
        this.keyString = suburb.getKeyString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getKeyString() {
        return keyString;
    }

    public void setKeyString(String keyString) {
        this.keyString = keyString;
    }
}
