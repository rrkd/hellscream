package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.QuoteContactMsg;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.model.vo.QuoteContactMsgVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import au.com.iglooit.hellscream.repository.BaseRepository;
import com.google.appengine.api.datastore.KeyFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 1/10/2014
 * Time: 3:24 PM
 */
@Repository
@Transactional
public class QuoteContactMsgDAOImpl extends BaseRepository<QuoteContactMsg>
        implements QuoteContactMsgDAO {
    @Resource
    private MerchantDAO merchantDAO;
    @Resource
    private QuoteTransactionDAO quoteTransactionDAO;
    @Resource
    private UserDAO userDAO;

    private static final Integer PAGE_COUNT = 10;
    public QuoteContactMsgDAOImpl() {
        super(QuoteContactMsg.class);
    }

    @Override
    public void createQuoteContactMsg(QuoteContactMsg msg) {
        add(msg);
    }

    @Override
    public SearchResultVO<QuoteContactMsgVO> findContactMsg(Merchant merchant, Integer page) {
        Integer startPage = page == null ? 1 : page;
        Query q = getEntityManager()
                .createQuery("select q from QuoteContactMsg q " +
                        "where q.merchantKey=:merchantKey ")
                .setParameter("merchantKey", merchant.getKey())
                .setMaxResults(PAGE_COUNT)
                .setFirstResult((startPage - 1) * PAGE_COUNT);
        Query countQuery = getEntityManager()
                .createQuery("select count(q) from QuoteContactMsg q " +
                        "where q.merchantKey=:merchantKey ")
                .setParameter("merchantKey", merchant.getKey());
        SearchResultVO<QuoteContactMsgVO> resultVO = new SearchResultVO<QuoteContactMsgVO>();

        for (QuoteContactMsg qs : (List<QuoteContactMsg>) q.getResultList()) {
            QuoteContactMsgVO vo = new QuoteContactMsgVO();
            vo.setMerchantKey(KeyFactory.keyToString(qs.getMerchantKey()));
            vo.setQuoteTransactionKey(KeyFactory.keyToString(qs.getQuoteTransactionKey()));
            QuoteTransaction qt = quoteTransactionDAO.findByKey(qs.getQuoteTransactionKey());
            vo.setTitle(qt.getQuote().getTitle());
            vo.setPostDate(qs.getPostDate());
            IGUser user = userDAO.findByEmail(qt.getQuote().getClientUserEmail());
            vo.setUserKey(user.getKeyString());
            vo.setUserEmail(user.getEmail());
            vo.setUserName(user.getNickname());
            vo.setUserForename(user.getForename());
            vo.setUserSurname(user.getSurname());
            vo.setUserPhone(user.getMobile());

            resultVO.getVoList().add(vo);
        }
        resultVO.setPageNum(startPage);
        resultVO.setTotal(((Long)countQuery.getSingleResult()).intValue() / PAGE_COUNT + 1);
        return resultVO;
    }
}
