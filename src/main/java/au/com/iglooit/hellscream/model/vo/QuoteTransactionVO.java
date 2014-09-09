package au.com.iglooit.hellscream.model.vo;

import au.com.iglooit.hellscream.model.entity.ServiceAvailableType;

import java.io.Serializable;

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

    private QuoteTransactionVO() {

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
}
