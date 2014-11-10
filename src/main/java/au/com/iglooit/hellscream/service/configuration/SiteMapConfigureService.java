package au.com.iglooit.hellscream.service.configuration;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 10/11/2014
 * Time: 11:41 AM
 */
@Component
public class SiteMapConfigureService {
    private static final Logger LOG = LoggerFactory.getLogger(SiteMapConfigureService.class);
    private String siteMapStr;

    @PostConstruct
    public void init() throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("seo/sitemap.xml");
        siteMapStr = IOUtils.toString(is, "UTF-8");
    }

    public String getSiteMapStr() {
        return siteMapStr;
    }
}
