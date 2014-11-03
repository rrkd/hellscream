package au.com.iglooit.hellscream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 3/11/2014
 * Time: 8:06 AM
 */
@Controller
public class SEOController {

    @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
    public void homePage(HttpServletResponse response) throws IOException {
        response.getWriter().print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<urlset\n" +
                "      xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\"\n" +
                "      xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "      xsi:schemaLocation=\"http://www.sitemaps.org/schemas/sitemap/0.9\n" +
                "            http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd\">\n" +
                "<!-- created with Free Online Sitemap Generator www.xml-sitemaps.com -->\n" +
                "\n" +
                "<url>\n" +
                "  <loc>http://spring-forest-538.appspot.com/home</loc>\n" +
                "  <priority>1.00</priority>\n" +
                "</url>" +
                "</urlset>");
    }
}
