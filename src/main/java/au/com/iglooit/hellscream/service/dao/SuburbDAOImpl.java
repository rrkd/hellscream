package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Suburb;
import au.com.iglooit.hellscream.model.vo.SuburbVO;
import au.com.iglooit.hellscream.repository.BaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 24/09/2014
 * Time: 9:16 PM
 */
@Repository
@Transactional
public class SuburbDAOImpl extends BaseRepository<Suburb> implements SuburbDAO {
    public SuburbDAOImpl() {
        super(Suburb.class);
    }

    @Override
    public void createSuburb(Suburb suburb) {
        add(suburb);
    }

    @Override
    public Suburb findByName(String name) {
        Query q = getEntityManager()
                .createQuery("select q from Suburb q " +
                        "where q.name=:name ")
                .setMaxResults(1)
                .setParameter("name", name);
        return q.getResultList().size() > 0 ? ((List<Suburb>) q.getResultList()).get(0) : null;
    }

    @Override
    public Suburb findByPostcode(String postCode) {
        Query q = getEntityManager()
                .createQuery("select q from Suburb q " +
                        "where q.postCode=:postCode ")
                .setMaxResults(1)
                .setParameter("postCode", postCode);
        return q.getResultList().size() > 0 ? ((List<Suburb>) q.getResultList()).get(0) : null;
    }

    @Override
    public List<SuburbVO> findByKeyword(String key) {
        List<SuburbVO> result = new ArrayList<>();
        Query q = getEntityManager()
                .createQuery("select q from Suburb q " +
                        "where q.name>=:name1 and q.name<:name2")
                .setParameter("name1", key.toUpperCase())
                .setParameter("name2", key.toUpperCase() + "ZZZZZZZZZZZ");
        for(Suburb suburb : (List<Suburb>)q.getResultList()) {
            SuburbVO vo = new SuburbVO(suburb);
            result.add(vo);
        }
        return result;
    }

    @Override
    public Long count() {
        Query q = getEntityManager()
                .createQuery("select count(1) from Suburb q ");
        return (Long)q.getSingleResult();
    }
}
