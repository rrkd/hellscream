package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuotePostMsg;
import au.com.iglooit.hellscream.model.vo.QuotePostMsgVO;
import au.com.iglooit.hellscream.model.vo.QuoteVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import au.com.iglooit.hellscream.repository.BaseRepository;
import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class QuotePostMsgDAOImpl extends BaseRepository<QuotePostMsg> implements QuotePostMsgDAO {
    private static final Integer PAGE_COUNT = 10;
    public QuotePostMsgDAOImpl() {
        super(QuotePostMsg.class);
    }

    @Resource
    private MerchantDAO merchantDAO;
    @Resource
    private QuoteDAO quoteDAO;

    @Override
    public void createQuotePostMsg(QuotePostMsg msg) {
        add(msg);
    }

    @Override
    public List<QuotePostMsgVO> findByMerchant(Key merchantKey) {
        Query q = getEntityManager()
            .createQuery("select q from QuotePostMsg q " +
                "where q.merchantKey = :merchantKey and q.status = :status")
            .setParameter("merchantKey", merchantKey)
            .setParameter("status", QuotePostMsg.Status.Unread.toString());
        List<QuotePostMsg> quoteList = q.getResultList();
        List<QuotePostMsgVO> result = new ArrayList<>();
        for (QuotePostMsg msg : quoteList) {
            QuotePostMsgVO vo = new QuotePostMsgVO();
//            vo.setMerchant(merchantDAO.findByKey(msg.getMerchantKey()));
            vo.setQuote(new QuoteVO(quoteDAO.findByKey(msg.getQuoteKey())));
            vo.setKeyString(msg.getKeyString());
            result.add(vo);
        }
        return result;
    }

    @Override
    public SearchResultVO<QuotePostMsgVO> findByMerchant(Key merchantKey, Integer page) {
        Integer startPage = page == null ? 1 : page;
        Query q = getEntityManager()
            .createQuery("select q from QuotePostMsg q " +
                "where q.merchantKey = :merchantKey and q.status = :status")
            .setParameter("merchantKey", merchantKey)
            .setParameter("status", QuotePostMsg.Status.Unread.toString())
            .setMaxResults(PAGE_COUNT)
            .setFirstResult((startPage - 1) * PAGE_COUNT);
        Query countQuery = getEntityManager()
            .createQuery("select count(q) from QuotePostMsg q " +
                "where q.merchantKey = :merchantKey and q.status = :status")
            .setParameter("merchantKey", merchantKey)
            .setParameter("status", QuotePostMsg.Status.Unread.toString());

        List<QuotePostMsg> quoteList = q.getResultList();
        List<QuotePostMsgVO> voList = new ArrayList<>();
        for (QuotePostMsg msg : quoteList) {
            QuotePostMsgVO vo = new QuotePostMsgVO();
//            vo.setMerchant(merchantDAO.findByKey(msg.getMerchantKey()));
            vo.setQuote(new QuoteVO(quoteDAO.findByKey(msg.getQuoteKey())));
            vo.setKeyString(msg.getKeyString());
            voList.add(vo);
        }


        SearchResultVO<QuotePostMsgVO> resultVO = new SearchResultVO<QuotePostMsgVO>();

        resultVO.setVoList(voList);
        resultVO.setPageNum(startPage);
        resultVO.setTotal(((Long) countQuery.getSingleResult()).intValue() / PAGE_COUNT + 1);
        return resultVO;
    }
}
