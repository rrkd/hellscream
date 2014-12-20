package au.com.iglooit.hellscream.model.entity;

import au.com.iglooit.hellscream.model.GeoIndexTypeConstant;
import au.com.iglooit.hellscream.utils.CanonicalSlugIdConvert;
import au.com.iglooit.hellscream.utils.DescriptionUtils;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.search.Document;
import com.google.appengine.api.search.Field;
import com.google.appengine.api.search.GeoPoint;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:44 AM
 */
@Entity
public class Merchant extends BaseEntity {
    private static final String DEFAULT_MERCHANT_IMG = "/assets/img/default-merchant1.jpeg";
    // must be unique
    private String tradeName;
    private String merchantName;
    private Text description;
    private String address1;
    private String address2;
    private String address3;
    private String email;
    private String phone;
    private String mobile;
    private String contact1;
    private String contact2;
    private Date lastUpdateTime;
    private Date postDate;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<String> categoryList;
    private String postcode;
    private String suburb;
    private String formatAddress;
    private String imageResourceId;
    private String imageFileName = DEFAULT_MERCHANT_IMG;
    private String canonicalSlugId;
    private Integer rank = 3;
    private Integer feedbackCount = 0;
    private Integer quoteCount = 0;
    private Integer applyQuoteCount = 0;
    private MerchantType merchantType = MerchantType.Searchable;
    private MerchantBillType billType = MerchantBillType.NORMAL;
    private String payPalEmail;

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

    public Text getDescription() {
        return description;
    }

    public void setDescription(Text description) {
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
        return CanonicalSlugIdConvert.convertToURL(tradeName);
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String convertToAddress() {
        return address1 + " " + address2 + " " + address3;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public String getShortDesc() {
        return DescriptionUtils.build(description.getValue());
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getFormatAddress() {
        return formatAddress;
    }

    public void setFormatAddress(String formatAddress) {
        this.formatAddress = formatAddress;
    }

    public String getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(String imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getImageFileName() {
        return StringUtils.isNotBlank(imageFileName) ? imageFileName : DEFAULT_MERCHANT_IMG;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getCanonicalSlugId() {
        return canonicalSlugId;
    }

    public void setCanonicalSlugId(String canonicalSlugId) {
        this.canonicalSlugId = canonicalSlugId;
    }

    public Integer getRank() {
        return rank == null ? 3 : rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getFeedbackCount() {
        return feedbackCount == null ? 0 : feedbackCount;
    }

    public void setFeedbackCount(Integer feedbackCount) {
        this.feedbackCount = feedbackCount;
    }

    public Integer getQuoteCount() {
        return quoteCount == null ? 0 : quoteCount;
    }

    public void setQuoteCount(Integer quoteCount) {
        this.quoteCount = quoteCount;
    }

    public Integer getApplyQuoteCount() {
        return applyQuoteCount == null ? 0 : applyQuoteCount;
    }

    public void setApplyQuoteCount(Integer applyQuoteCount) {
        this.applyQuoteCount = applyQuoteCount;
    }

    public MerchantType getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(MerchantType merchantType) {
        this.merchantType = merchantType;
    }

    public MerchantBillType getBillType() {
        return billType;
    }

    public void setBillType(MerchantBillType billType) {
        this.billType = billType;
    }

    public String getPayPalEmail() {
        return payPalEmail;
    }

    public void setPayPalEmail(String payPalEmail) {
        this.payPalEmail = payPalEmail;
    }

    @Override
    public Document toFullTextDocument() {
        Document.Builder builder = Document.newBuilder()
                .setId(KeyFactory.keyToString(getKey()))
                .addField(Field.newBuilder().setName("tradeName").setText(getTradeName()))
                .addField(Field.newBuilder().setName("email").setText(getEmail()))
                .addField(Field.newBuilder().setName("merchantName").setText(getMerchantName()))
                .addField(Field.newBuilder().setName("description").setText(getDescription().getValue()))
                .addField(Field.newBuilder().setName("phone").setText(getPhone()));
        if (latitude != null && longitude != null) {
            builder.addField(Field.newBuilder().setName("point").setGeoPoint(
                    new GeoPoint(latitude.doubleValue(), longitude.doubleValue())));
        }

        builder.addField(Field.newBuilder().setName("address").setText(
                StringUtils.isBlank(getFormatAddress()) ? "" : getFormatAddress()))
                .addField(Field.newBuilder().setName("suburb").setText(
                        StringUtils.isBlank(getSuburb()) ? "" : getSuburb()))
                .addField(Field.newBuilder().setName("postcode").setText(
                        StringUtils.isBlank(getPostcode()) ? "" : getPostcode()))
                .addField(Field.newBuilder().setName("mobile").setText(getMobile()));
        for (String category : categoryList) {
            builder.addField(Field.newBuilder().setName("category").setText(category));
        }
        return builder.build();

    }

    @Override
    public Document toGeoDocument() {
        Document.Builder builder = Document.newBuilder()
                .setId("geo-" + KeyFactory.keyToString(getKey()));
        if (latitude != null && longitude != null) {
            builder.addField(Field.newBuilder().setName("point").setGeoPoint(
                    new GeoPoint(latitude.doubleValue(), longitude.doubleValue())));
        }
        builder.addField(Field.newBuilder().setName("type").setText(GeoIndexTypeConstant.MERCHANT_TYPE));

        return builder.build();
    }
}
