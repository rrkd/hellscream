package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.CategoryGroup;
import com.google.appengine.api.datastore.Key;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 26/08/2014
 * Time: 8:26 PM
 */
public interface CategoryGroupDAO extends IEntityService<CategoryGroup> {
    void createCategoryGroup(CategoryGroup group);
    CategoryGroup findByName(String name);
    List<CategoryGroup> loadAll();
    CategoryGroup loadByKey(Key key);
    CategoryGroup loadByUrl(String url);
}
