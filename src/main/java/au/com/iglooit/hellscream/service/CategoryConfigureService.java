package au.com.iglooit.hellscream.service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.model.entity.CategoryGroup;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.service.dao.CategoryGroupManageService;
import au.com.iglooit.hellscream.service.dao.CategoryManageService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 25/08/2014
 * Time: 5:04 PM
 */
@Component
public class CategoryConfigureService {
    @Resource
    private CategoryManageService categoryManageService;
    @Resource
    private CategoryGroupManageService categoryGroupManageService;
    private static final Logger LOG = LoggerFactory.getLogger(CategoryConfigureService.class);

    @PostConstruct
    public void init() throws Exception {
        LOG.info("init category");
        WebProperties webProperties = WebProperties.getInstance();
        Boolean initData = Boolean.valueOf(webProperties.get("init.data"));
        if (initData) {
            // delete category and categorygroup
            LOG.info("init model - all data will be removed.");
            LOG.info("Start to load category data");
            initCategoryGroup();
        }

    }

    private void initCategoryGroup() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("data/category_group.csv");
        CSVReader reader = new CSVReader(new InputStreamReader(is));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            String categoryName = nextLine[0];
            String categoryGroupName = nextLine[1];
            if (!StringUtils.isBlank(categoryName) && !StringUtils.isBlank(categoryGroupName)) {
                // find CategoryGroup
                CategoryGroup group = categoryGroupManageService.findByName(categoryGroupName);
                if (group == null) {
                    //create group
                    group = new CategoryGroup();
                    group.setName(categoryGroupName);
                    group.setDescription(categoryGroupName);
                    categoryGroupManageService.createCategoryGroup(group);
                }
                Category category = categoryManageService.findByName(categoryName);
                if (category == null) {
                    category = new Category();
                    category.setName(categoryName);
                    category.setDescription(categoryName);
                    category.setGroup(group);
                    LOG.info("crate category: " + categoryName);
                    categoryManageService.createCategory(category);
                } else {
                    category.setName(categoryName);
                    category.setDescription(categoryName);
                    category.setGroup(group);
                    categoryManageService.update(category);
                    LOG.info("update category: " + categoryName);
                }
            }
        }
    }

    private void removeCategory() {
        List<Category> categoryList = categoryManageService.findAll();
        for (Category category : categoryList) {
            categoryManageService.removeEntity(category);
        }

    }

    private void removeCategoryGroup() {
        List<CategoryGroup> categoryGroupList = categoryGroupManageService.findAll();
        for (CategoryGroup categoryGroup : categoryGroupList) {
            categoryGroupManageService.removeEntity(categoryGroup);
        }
    }
}
