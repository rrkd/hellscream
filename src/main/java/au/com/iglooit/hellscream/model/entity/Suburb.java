package au.com.iglooit.hellscream.model.entity;

import au.com.iglooit.hellscream.model.GeoIndexTypeConstant;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.search.Document;
import com.google.appengine.api.search.Field;
import com.google.appengine.api.search.GeoPoint;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 24/09/2014
 * Time: 9:04 PM
 */
@Entity
public class Suburb extends BaseEntity {
    private String name;
    private String postCode;
    private String state;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public Suburb() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    @Override
    public Document toFullTextDocument() {
        Document.Builder builder = Document.newBuilder()
                .setId(KeyFactory.keyToString(getKey()))
                .addField(Field.newBuilder().setName("name").setText(getName()))
                .addField(Field.newBuilder().setName("postCode").setText(getPostCode()))
                .addField(Field.newBuilder().setName("state").setText(getState()))
                .addField(Field.newBuilder().setName("point").setGeoPoint(
                        new GeoPoint(latitude.doubleValue(), longitude.doubleValue())));
        return builder.build();
    }

    @Override
    public Document toGeoDocument() {
        return Document.newBuilder()
                .setId("geo-" + KeyFactory.keyToString(getKey()))
                .addField(Field.newBuilder().setName("point").setGeoPoint(
                        new GeoPoint(latitude.doubleValue(), longitude.doubleValue())))
                .addField(Field.newBuilder().setName("type").setText(GeoIndexTypeConstant.MERCHANT_TYPE))
                .build();
    }
}
