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

    public SuburbVO() {

    }

    public SuburbVO(Suburb suburb) {
        this.id = suburb.getKeyString();
        this.text = suburb.getName() + " - " + suburb.getPostCode() + " (" + suburb.getState() + ")";
        this.postCode = suburb.getPostCode();
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
}
