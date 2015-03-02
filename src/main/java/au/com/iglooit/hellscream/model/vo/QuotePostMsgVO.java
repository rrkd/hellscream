package au.com.iglooit.hellscream.model.vo;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;

/**
 * Created by nicholaszhu on 24/02/2015.
 */
public class QuotePostMsgVO {
    private String keyString;
    private MerchantVO merchant;
    private QuoteVO quote;

    public MerchantVO getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantVO merchant) {
        this.merchant = merchant;
    }

    public QuoteVO getQuote() {
        return quote;
    }

    public void setQuote(QuoteVO quote) {
        this.quote = quote;
    }

    public String getKeyString() {
        return keyString;
    }

    public void setKeyString(String keyString) {
        this.keyString = keyString;
    }
}
