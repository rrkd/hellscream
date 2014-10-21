package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 25/08/2014
 * Time: 5:11 PM
 */
public interface CategoryDAO extends IEntityService<Category>{
    void createCategory(Category category);
    Category findByName(String name);
    Category findByTradeName(String tradeName);
    List<Category> findByCategory(String category);
    Category findByCategoryUrl(String categoryUrl);
    List<Category> findTopCategory(Integer size);
}
