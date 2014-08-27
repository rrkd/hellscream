package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 25/08/2014
 * Time: 5:11 PM
 */
@Repository
public class CategoryManageServiceImpl extends BaseRepository<Category> implements CategoryManageService {
    public CategoryManageServiceImpl() {
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

}
