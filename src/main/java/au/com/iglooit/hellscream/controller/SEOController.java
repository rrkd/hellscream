package au.com.iglooit.hellscream.controller;

import au.com.iglooit.hellscream.service.configuration.SitemapConfigureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 3/11/2014
 * Time: 8:06 AM
 */
@Controller
public class SEOController {
    private static final Logger LOG = LoggerFactory.getLogger(SEOController.class);
    @Resource
    private SitemapConfigureService siteMapConfigureService;

    @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
    public void homePage(HttpServletResponse response) throws IOException {
        response.getWriter().print(siteMapConfigureService.getSiteMapStr());
    }
}
