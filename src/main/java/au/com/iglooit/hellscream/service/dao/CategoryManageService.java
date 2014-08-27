package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 25/08/2014
 * Time: 5:11 PM
 */
public interface CategoryManageService extends IEntityService<Category>{
    void createCategory(Category category);
    Category findByName(String name);
}
