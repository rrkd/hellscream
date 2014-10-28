package au.com.iglooit.hellscream.service.configuration;

import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.model.entity.CategoryGroup;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.service.dao.CategoryDAO;
import au.com.iglooit.hellscream.service.dao.CategoryGroupDAO;
import au.com.iglooit.hellscream.utils.CanonicalSlugIdConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 4/10/2014
 * Time: 4:16 PM
 */
@Component
public class DummyContentCfgService {
    private static final Logger LOG = LoggerFactory.getLogger(DummyContentCfgService.class);
    private static final String TEST_CATEGORY_GROUP = "test group";
    private static final String TEST_CATEGORY_ONE = "test category one";
    private static final String TEST_CATEGORY_TWO = "test category two";
    @Resource
    private CategoryGroupDAO categoryGroupDAO;
    @Resource
    private CategoryDAO categoryDAO;

    @PostConstruct
    public void init() throws Exception {
        WebProperties webProperties = WebProperties.getInstance();
        Boolean initData = Boolean.valueOf(webProperties.get("init.dummy.data"));
        if (initData) {
            LOG.info("init dummy data.");
            initDummyConfig();
        }
    }

    private void initDummyConfig() {
        // create test category group "test group"
        CategoryGroup categoryGroup = categoryGroupDAO.findByName(TEST_CATEGORY_GROUP);
        if (categoryGroup == null) {
            categoryGroup = new CategoryGroup();
            categoryGroup.setName(TEST_CATEGORY_GROUP);
            categoryGroup.setDescription("this is test category group");
            categoryGroup.setUrl(CanonicalSlugIdConvert.convertToURL("test group"));
            categoryGroupDAO.createCategoryGroup(categoryGroup);
            LOG.info("create test category group.");
        }

        // create test category "test category one" and "test category two"
        if (categoryDAO.findByName(TEST_CATEGORY_ONE) == null) {
            Category category1 = new Category();
            category1.setName(TEST_CATEGORY_ONE);
            category1.setGroup(categoryGroup);
            category1.setDescription("this is test category one");
            category1.setUrl(CanonicalSlugIdConvert.convertToURL("test category one"));
            categoryDAO.createCategory(category1);
            LOG.info("create test category one.");
        }

        if (categoryDAO.findByName(TEST_CATEGORY_TWO) == null) {
            Category category2 = new Category();
            category2.setName(TEST_CATEGORY_TWO);
            category2.setGroup(categoryGroup);
            category2.setDescription("this is test category two");
            category2.setUrl(CanonicalSlugIdConvert.convertToURL("test category two"));
            categoryDAO.createCategory(category2);
            LOG.info("create test category two.");
        }

    }
}
