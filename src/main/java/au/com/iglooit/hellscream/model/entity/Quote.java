package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.search.Document;
import com.google.appengine.datanucleus.annotations.Unowned;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 1/09/2014
 * Time: 8:27 PM
 */
@Entity
public class Quote extends BaseEntity {
    private String title;
    private String description;
    private List<String> postCodeList;
    private List<String> categoryList;
    private String clientUserEmail;
    private List<String> sendEmailList;
    private List<String> returnEmailList;
    private Date postDate;
    private Date updateDate;
    @Basic
    private Key suburbKey;
    @Enumerated(EnumType.STRING)
    private QuoteStatus status = QuoteStatus.Quoting;
    @Basic
    private List<Key> userSelectedMerchant;
    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<QuoteTransaction> quoteTransactions = new ArrayList<>();

    public Quote() {

    }

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

    public List<String> getPostCodeList() {
        return postCodeList;
    }

    public void setPostCodeList(List<String> postCodeList) {
        this.postCodeList = postCodeList;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public String getClientUserEmail() {
        return clientUserEmail;
    }

    public void setClientUserEmail(String clientUserEmail) {
        this.clientUserEmail = clientUserEmail;
    }

    public List<String> getSendEmailList() {
        return sendEmailList;
    }

    public void setSendEmailList(List<String> sendEmailList) {
        this.sendEmailList = sendEmailList;
    }

    public List<String> getReturnEmailList() {
        return returnEmailList;
    }

    public void setReturnEmailList(List<String> returnEmailList) {
        this.returnEmailList = returnEmailList;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<Key> getUserSelectedMerchant() {
        return userSelectedMerchant;
    }

    public void setUserSelectedMerchant(List<Key> userSelectedMerchant) {
        this.userSelectedMerchant = userSelectedMerchant;
    }

    public List<QuoteTransaction> getQuoteTransactions() {
        return quoteTransactions;
    }

    public QuoteStatus getStatus() {
        return status;
    }

    public void setStatus(QuoteStatus status) {
        this.status = status;
    }

    public void setQuoteTransactions(List<QuoteTransaction> quoteTransactions) {
        this.quoteTransactions = quoteTransactions;
    }

    @Override
    public Document toFullTextDocument() {
        throw new UnsupportedOperationException("Quote can't support full text search");
    }

    @Override
    public Document toGeoDocument() {
        throw new UnsupportedOperationException("Quote can't support Geo search");
    }

    public Key getSuburbKey() {
        return suburbKey;
    }

    public void setSuburbKey(Key suburbKey) {
        this.suburbKey = suburbKey;
    }

    public Integer getQuoteTransactionCount(){
        return quoteTransactions == null ? 0 : quoteTransactions.size();
    }
}
