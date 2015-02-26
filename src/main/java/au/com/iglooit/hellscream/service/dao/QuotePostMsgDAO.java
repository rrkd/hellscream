package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.QuotePostMsg;
import au.com.iglooit.hellscream.model.vo.QuotePostMsgVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import com.google.appengine.api.datastore.Key;

import java.util.List;

/**
 * Created by nicholaszhu on 24/02/2015.
 */
public interface QuotePostMsgDAO extends IEntityService<QuotePostMsg> {
    void createQuotePostMsg(QuotePostMsg msg);

    List<QuotePostMsgVO> findByMerchant(Key merchantKey);

    SearchResultVO<QuotePostMsgVO> findByMerchant(Key merchantKey, Integer page);
}
