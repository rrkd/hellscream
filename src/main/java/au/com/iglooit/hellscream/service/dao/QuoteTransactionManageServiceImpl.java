package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.repository.BaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 3/09/2014
 * Time: 2:05 PM
 */
@Repository
@Transactional
public class QuoteTransactionManageServiceImpl extends BaseRepository<QuoteTransaction>
        implements QuoteTransactionManageService {
    public QuoteTransactionManageServiceImpl() {
        super(QuoteTransaction.class);
    }

    @Override
    public void createQuoteTransaction(QuoteTransaction quoteTransaction) {
        add(quoteTransaction);
    }
}
