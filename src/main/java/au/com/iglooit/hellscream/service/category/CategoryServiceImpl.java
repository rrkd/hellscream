package au.com.iglooit.hellscream.service.category;

import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.model.entity.CategoryGroup;
import au.com.iglooit.hellscream.service.dao.CategoryDAO;
import au.com.iglooit.hellscream.service.dao.CategoryGroupDAO;
import au.com.iglooit.hellscream.utils.CanonicalSlugIdConvert;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 21/10/2014
 * Time: 8:17 AM
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Resource
    private CategoryDAO categoryDAO;
    @Resource
    private CategoryGroupDAO categoryGroupDAO;

    @Override
    public List<Category> homePageCategory() {
        return categoryDAO.findTopCategory(12);
    }

    @Override
    public void initCategory(String[] line) {
        String categoryName = line[0];
        String categoryTradeName = line[1];
        String categoryGroupName = line[2];
        String categoryGroupTradeName = line[3];
        String categoryKeywords = line[4];
        if (!StringUtils.isBlank(categoryName) && !StringUtils.isBlank(categoryGroupName)) {
            // find CategoryGroup
            CategoryGroup group = categoryGroupDAO.findByName(categoryGroupName);
            if (group == null) {
                //create group
                group = new CategoryGroup();
                group.setName(categoryGroupName);
                group.setTradeName(categoryGroupTradeName);
                group.setDescription(categoryGroupName);
                group.setUrl(CanonicalSlugIdConvert.convertToURL(categoryGroupName));
                group.setCategoryCount(0L);
                categoryGroupDAO.createCategoryGroup(group);
                categoryGroupDAO.getEntityManager().flush();
            }
            Category category = categoryDAO.findByName(categoryName);
            if (category == null) {
                category = new Category();
                category.setName(categoryName);
                category.setTradeName(categoryTradeName);
                category.setDescription(categoryName);
                category.setKeywords(categoryKeywords);
                category.setGroup(group);
                category.setUrl(CanonicalSlugIdConvert.convertToURL(categoryName));
                category.setMerchantCount(0L);
                LOG.info("crate category: " + categoryName);
                categoryDAO.createCategory(category);
                group.setCategoryCount(group.getCategoryCount() + 1);
                categoryGroupDAO.update(group);
            } else {
                category.setName(categoryName);
                category.setTradeName(categoryTradeName);
                category.setDescription(categoryName);
                category.setKeywords(categoryKeywords);
                category.setGroup(group);
                category.setUrl(CanonicalSlugIdConvert.convertToURL(categoryName));
                categoryDAO.update(category);
                LOG.info("update category: " + categoryName);
            }
        }
    }
}
