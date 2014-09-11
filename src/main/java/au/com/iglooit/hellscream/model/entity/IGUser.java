package au.com.iglooit.hellscream.model.entity;

import au.com.iglooit.hellscream.security.AppRole;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.search.Document;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 7/04/2014
 * Time: 10:03 PM
 */
@Entity
public class IGUser extends BaseEntity {
    private String userId;
    private String email;
    private String nickname;
    private String forename;
    private String surname;
    private Set<AppRole> authorities;
    private boolean enabled;
    private String mobile;
    private String address1;
    private String address2;
    private String address3;
    @Basic
    private Key merchantKey;

    public IGUser () {

    }

    /**
     * Pre-registration constructor.
     *
     * Assigns the user the "NEW_USER" role only.
     */
    public IGUser(String userId, String nickname, String email) {
        this.userId = userId;
        this.nickname = nickname;
        this.authorities = EnumSet.of(AppRole.NEW_USER);
        this.forename = null;
        this.surname = null;
        this.email = email;
        this.enabled = true;
    }

    /**
     * Post-registration constructor
     */
    public IGUser(String userId, String nickname, String email, String forename, String surname,
                  Set<AppRole> authorities, boolean enabled) {
        this.userId = userId;
        this.nickname = nickname;
        this.email = email;
        this.authorities = authorities;
        this.forename = forename;
        this.surname = surname;
        this.enabled= enabled;
    }

    public String getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Collection<AppRole> getAuthorities() {
        return authorities;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAuthorities(Set<AppRole> authorities) {
        this.authorities = authorities;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Key getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(Key merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    @Override
    public String toString() {
        return "GaeUser{" +
                "userId='" + userId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    @Override
    public Document toFullTextDocument() {
        throw new UnsupportedOperationException("IGUser can't support full text search");
    }

    @Override
    public Document toGeoDocument() {
        throw new UnsupportedOperationException("IGUser can't support Geo search");
    }
}
