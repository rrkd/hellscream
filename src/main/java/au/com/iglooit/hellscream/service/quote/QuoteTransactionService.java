package au.com.iglooit.hellscream.service.quote;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.model.vo.QuoteMessageVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 10/09/2014
 * Time: 6:16 AM
 */
public interface QuoteTransactionService {
    List<QuoteMessageVO> findLatestMessage(Merchant merchant);
    void contactMerchant(QuoteTransaction quoteTransaction);
}
