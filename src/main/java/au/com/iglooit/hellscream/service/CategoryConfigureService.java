package au.com.iglooit.hellscream.service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.iglooit.hellscream.model.entity.Category;
import au.com.iglooit.hellscream.model.entity.CategoryGroup;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.service.category.CategoryService;
import au.com.iglooit.hellscream.service.dao.CategoryDAO;
import au.com.iglooit.hellscream.service.dao.CategoryGroupDAO;
import au.com.iglooit.hellscream.utils.CanonicalSlugIdConvert;
import au.com.iglooit.hellscream.utils.CategoryIdentifierConvert;
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
 * IGUser: nicholas.zhu
 * Date: 25/08/2014
 * Time: 5:04 PM
 */
@Component
public class CategoryConfigureService {
    @Resource
    private CategoryService categoryService;
    private static final Logger LOG = LoggerFactory.getLogger(CategoryConfigureService.class);

    @PostConstruct
    public void init() throws Exception {
        WebProperties webProperties = WebProperties.getInstance();
        Boolean initData = Boolean.valueOf(webProperties.get("init.category.data"));
        if (initData) {
            // delete category and categorygroup
            LOG.info("init model - all data will be removed.");
            LOG.info("Start to load category data");
            initCategoryGroup();
        }

    }

    private void initCategoryGroup() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("data/category.csv");
        CSVReader reader = new CSVReader(new InputStreamReader(is, "UTF-8"));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            categoryService.initCategory(nextLine);
        }
    }
}
