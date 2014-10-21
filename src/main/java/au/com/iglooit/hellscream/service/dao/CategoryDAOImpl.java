package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.repository.BaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 25/08/2014
 * Time: 5:11 PM
 */
@Repository
@Transactional
public class CategoryDAOImpl extends BaseRepository<Category> implements CategoryDAO {
    public CategoryDAOImpl() {
        super(Category.class);
    }

    @Override
    public void createCategory(Category category) {
        add(category);
    }

    @Override
    public Category findByName(String name) {
        Query q = getEntityManager().createQuery("select c from Category c where c.name=:name ")
                .setParameter("name", name);
        List<Category> result = q.getResultList();
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public Category findByTradeName(String tradeName) {
        Query q = getEntityManager().createQuery("select c from Category c where c.tradeName=:tradeName ")
                .setParameter("tradeName", tradeName);
        List<Category> result = q.getResultList();
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public List<Category> findByCategory(String category) {

        Query q = getEntityManager().createQuery("select c from Category c where c.group.name=:category ")
                .setParameter("category", category);
        return q.getResultList();
    }

    @Override
    public Category findByCategoryUrl(String categoryUrl) {
        Query q = getEntityManager().createQuery("select c from Category c where c.url=:url ")
                .setParameter("url", categoryUrl);
        List<Category> result = q.getResultList();
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public List<Category> findTopCategory(Integer size) {
        Query q = getEntityManager().createQuery("select c from Category c order by c.name")
                .setMaxResults(size);
        return q.getResultList();
    }

}
