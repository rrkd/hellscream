package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.QuoteContactMsg;
import au.com.iglooit.hellscream.model.vo.QuoteContactMsgVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 1/10/2014
 * Time: 3:23 PM
 */
public interface QuoteContactMsgDAO extends IEntityService<QuoteContactMsg> {
    void createQuoteContactMsg(QuoteContactMsg msg);

    SearchResultVO<QuoteContactMsgVO> findContactMsg(Merchant merchant, Integer page);
}
