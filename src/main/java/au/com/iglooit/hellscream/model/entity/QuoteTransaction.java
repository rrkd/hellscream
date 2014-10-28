package au.com.iglooit.hellscream.model.entity;

import au.com.iglooit.hellscream.model.vo.QuoteTransactionVO;
import com.google.appengine.api.search.Document;
import com.google.appengine.datanucleus.annotations.Unowned;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 2/09/2014
 * Time: 5:59 AM
 */
@Entity
public class QuoteTransaction extends BaseEntity {
    @Unowned
    private Merchant merchant;
    private String comment;
    private Double rawPrice;
    private Integer rawDay;
    @Enumerated(EnumType.STRING)
    private ServiceAvailableType serviceAvailableType;
    @Enumerated(EnumType.STRING)
    private QuoteTransactionStatus quoteTransactionStatus = QuoteTransactionStatus.Appending;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quote quote;

    public QuoteTransaction() {

    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
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

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public ServiceAvailableType getServiceAvailableType() {
        return serviceAvailableType;
    }

    public void setServiceAvailableType(ServiceAvailableType serviceAvailableType) {
        this.serviceAvailableType = serviceAvailableType;
    }

    public QuoteTransactionStatus getQuoteTransactionStatus() {
        return quoteTransactionStatus;
    }

    public void setQuoteTransactionStatus(QuoteTransactionStatus quoteTransactionStatus) {
        this.quoteTransactionStatus = quoteTransactionStatus;
    }

    @Override
    public Document toFullTextDocument() {
        throw new UnsupportedOperationException("QuoteTransaction can't support full text search");
    }

    @Override
    public Document toGeoDocument() {
        throw new UnsupportedOperationException("QuoteTransaction can't support Geo search");
    }

    public void convertFromVO(QuoteTransactionVO vo) {
        this.comment = vo.getComment();
        this.rawDay = vo.getRawDay();
        this.rawPrice = vo.getRawPrice();
        this.serviceAvailableType = vo.getServiceType();
    }
}
