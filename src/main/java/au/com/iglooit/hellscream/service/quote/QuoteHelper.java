package au.com.iglooit.hellscream.service.quote;

import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.service.mail.UserContactEmailVO;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 9/09/2014
 * Time: 8:11 PM
 */
public final class QuoteHelper {
    private QuoteHelper() {

    }

    public static UserContactEmailVO generateUserContactEmailVO(QuoteTransaction quoteTransaction) {
        UserContactEmailVO vo = new UserContactEmailVO();
        return vo;
    }
}
