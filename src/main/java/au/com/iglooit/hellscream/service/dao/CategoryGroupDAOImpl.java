package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.CategoryGroup;
import au.com.iglooit.hellscream.repository.BaseRepository;
import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 26/08/2014
 * Time: 8:26 PM
 */
@Repository
@Transactional
public class CategoryGroupDAOImpl extends BaseRepository<CategoryGroup>
        implements CategoryGroupDAO {
    public CategoryGroupDAOImpl() {
        super(CategoryGroup.class);
    }

    @Override
    public void createCategoryGroup(CategoryGroup group) {
        add(group);
    }

    @Override
    public CategoryGroup findByName(String name) {
        Query q = getEntityManager().createQuery("select c from CategoryGroup c where c.name=:name ")
                .setParameter("name", name);
        List<CategoryGroup> result = q.getResultList();
        if (result != null && result.size() > 0) {
            result.get(0).getCategoryList().size();
            return result.get(0);
        }
        return null;
    }

    @Override
    public List<CategoryGroup> loadAll() {
        List<CategoryGroup> categoryGroupList = findAll();
        for (CategoryGroup group : categoryGroupList) {
            group.getCategoryList().size();
        }
        return categoryGroupList;
    }

    @Override
    public CategoryGroup loadByKey(Key key) {
        CategoryGroup category = findByKey(key);
        category.getCategoryList().size();
        return category;
    }

    @Override
    public CategoryGroup loadByUrl(String url) {
        Query q = getEntityManager().createQuery("select c from CategoryGroup c where c.url=:url ")
                .setParameter("url", url);
        List<CategoryGroup> result = q.getResultList();
        if (result != null && result.size() > 0) {
            result.get(0).getCategoryList().size();
            return result.get(0);
        }
        return null;
    }

}
