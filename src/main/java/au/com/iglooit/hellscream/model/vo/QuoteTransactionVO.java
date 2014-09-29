package au.com.iglooit.hellscream.model.vo;

import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.model.entity.QuoteTransactionStatus;
import au.com.iglooit.hellscream.model.entity.ServiceAvailableType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 8/09/2014
 * Time: 6:25 AM
 */
public class QuoteTransactionVO implements Serializable {
    private String comment;
    private Double rawPrice;
    private Integer rawDay;
    private ServiceAvailableType serviceType;
    private String merchantKeyString;
    private String quoteKeyString;
    private String quoteTitle;
    private String quoteComment;
    private String quoteSuburb;
    private Date quotePostDate;
    private QuoteTransactionStatus status;
    private List<String> quoteCategoryList;

    public QuoteTransactionVO() {

    }

    public QuoteTransactionVO(QuoteTransaction qt) {
        this.comment = qt.getComment();
        this.rawDay = qt.getRawDay();
        this.rawPrice = qt.getRawPrice();
        this.merchantKeyString = qt.getMerchant().getKeyString();
        this.serviceType = qt.getServiceAvailableType();
        this.quoteComment = qt.getQuote().getDescription();
        this.quoteKeyString = qt.getQuote().getKeyString();
        this.quoteTitle = qt.getQuote().getTitle();
        this.quotePostDate = qt.getQuote().getPostDate();
        this.quoteCategoryList = qt.getQuote().getCategoryList();
        this.status = qt.getQuoteTransactionStatus();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getRawPrice() {
        return rawPrice;
    }

    public void setRawPrice(Double rawPrice) {
        this.rawPrice = rawPrice;
    }

    public Integer getRawDay() {
        return rawDay;
    }

    public void setRawDay(Integer rawDay) {
        this.rawDay = rawDay;
    }

    public ServiceAvailableType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceAvailableType serviceType) {
        this.serviceType = serviceType;
    }

    public String getMerchantKeyString() {
        return merchantKeyString;
    }

    public void setMerchantKeyString(String merchantKeyString) {
        this.merchantKeyString = merchantKeyString;
    }

    public String getQuoteKeyString() {
        return quoteKeyString;
    }

    public void setQuoteKeyString(String quoteKeyString) {
        this.quoteKeyString = quoteKeyString;
    }

    public String getQuoteTitle() {
        return quoteTitle;
    }

    public void setQuoteTitle(String quoteTitle) {
        this.quoteTitle = quoteTitle;
    }

    public String getQuoteComment() {
        return quoteComment;
    }

    public void setQuoteComment(String quoteComment) {
        this.quoteComment = quoteComment;
    }

    public String getQuoteSuburb() {
        return quoteSuburb;
    }

    public void setQuoteSuburb(String quoteSuburb) {
        this.quoteSuburb = quoteSuburb;
    }

    public Date getQuotePostDate() {
        return quotePostDate;
    }

    public void setQuotePostDate(Date quotePostDate) {
        this.quotePostDate = quotePostDate;
    }

    public List<String> getQuoteCategoryList() {
        return quoteCategoryList;
    }

    public void setQuoteCategoryList(List<String> quoteCategoryList) {
        this.quoteCategoryList = quoteCategoryList;
    }

    public QuoteTransactionStatus getStatus() {
        return status;
    }

    public void setStatus(QuoteTransactionStatus status) {
        this.status = status;
    }
}
