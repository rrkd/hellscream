package au.com.iglooit.hellscream.model.entity;

import au.com.iglooit.hellscream.utils.MerchantIdentifierConvert;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.search.Document;
import com.google.appengine.api.search.Field;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:44 AM
 */
@Entity
public class Merchant extends BaseEntity {
    // must be unique
    private String tradeName;
    private String merchantName;
    private String description;
    private String address1;
    private String address2;
    private String address3;
    private String email;
    private String phone;
    private String mobile;
    private String contact1;
    private String contact2;

    public Merchant() {
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getUrl() {
        return MerchantIdentifierConvert.convertToURL(tradeName);
    }

    @Override
    public Document toDocument() {
        return Document.newBuilder()
                .setId(KeyFactory.keyToString(getKey()))
                .addField(Field.newBuilder().setName("tradeName").setText(getTradeName()))
                .addField(Field.newBuilder().setName("email").setText(getEmail()))
                .addField(Field.newBuilder().setName("merchantName").setText(getMerchantName()))
                .addField(Field.newBuilder().setName("description").setText(getDescription()))
                .addField(Field.newBuilder().setName("phone").setText(getPhone()))
                .addField(Field.newBuilder().setName("mobile").setText(getMobile()))
                .build();

    }
}
