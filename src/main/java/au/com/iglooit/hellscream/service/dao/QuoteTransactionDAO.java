package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 3/09/2014
 * Time: 2:04 PM
 */
public interface QuoteTransactionDAO extends IEntityService<QuoteTransaction> {
    void createQuoteTransaction(QuoteTransaction quoteTransaction);
    SearchResultVO<QuoteTransaction> findQuoteTransactionByMerchant(Merchant merchant, Integer page);
}
