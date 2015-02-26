package au.com.iglooit.hellscream.service.quote;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.vo.QuotePostMsgVO;
import au.com.iglooit.hellscream.model.vo.QuoteTransactionVO;
import au.com.iglooit.hellscream.model.vo.QuoteVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 6/09/2014
 * Time: 2:08 PM
 */
public interface QuoteService {
    List<Quote> loadUserQuoteList(String email);

    void createQuote(Quote quote);

    void createMerchantQuote(Quote quote, Merchant merchant);

    List<QuoteVO> latestQuoteList();

    SearchResultVO<QuoteTransactionVO> findQuoteTransactionByMerchant(Merchant merchant, Integer page);

    SearchResultVO<QuoteVO> loadUserQuoteList(String email, Integer page);

    SearchResultVO<QuoteVO> loadLatestUserQuoteList(String email);

    SearchResultVO<QuotePostMsgVO> loadUnapplyMerchantPostQuote(Merchant merchant, Integer page);
}
