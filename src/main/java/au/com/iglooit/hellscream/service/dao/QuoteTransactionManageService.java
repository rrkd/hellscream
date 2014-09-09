package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.QuoteTransaction;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 3/09/2014
 * Time: 2:04 PM
 */
public interface QuoteTransactionManageService extends IEntityService<QuoteTransaction> {
    void createQuoteTransaction(QuoteTransaction quoteTransaction);
}
