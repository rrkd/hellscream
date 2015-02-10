package au.com.iglooit.hellscream.model.vo;

import java.util.List;

/**
 * Created by nicholaszhu on 10/02/2015.
 */
public class MerchantQuoteVO {
    private String title;
    private String description;
    private String clientUserEmail;
    private String merchantKeyString;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClientUserEmail() {
        return clientUserEmail;
    }

    public void setClientUserEmail(String clientUserEmail) {
        this.clientUserEmail = clientUserEmail;
    }

    public String getMerchantKeyString() {
        return merchantKeyString;
    }

    public void setMerchantKeyString(String merchantKeyString) {
        this.merchantKeyString = merchantKeyString;
    }
}
