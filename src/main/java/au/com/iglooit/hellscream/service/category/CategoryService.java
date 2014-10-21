package au.com.iglooit.hellscream.service.category;

import au.com.iglooit.hellscream.model.entity.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 21/10/2014
 * Time: 8:17 AM
 */
public interface CategoryService {
    List<Category> homePageCategory();
    void initCategory(String[] line);
}
