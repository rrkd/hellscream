package au.com.iglooit.hellscream.service.mail;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 10/09/2014
 * Time: 8:15 PM
 */
public final class EmailTemplateHelper {
    private EmailTemplateHelper() {

    }

    /**
     * get the email template for quote email which send to merchant to mention where is new quote
     * @param vo
     * @return
     */
    public static String quoteMsgTemplate(QuoteEmailVO vo) {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty("resource.loader", "class");
        ve.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        ve.init();
        VelocityContext context = new VelocityContext();
        context.put("quoteEmailVO", vo);

        /*
         *   get the Template
         */

        Template t = ve.getTemplate("vm/quoteEmail.vm");

        /*
         *  now render the template into a Writer, here
         *  a StringWriter
         */

        StringWriter writer = new StringWriter();

        t.merge(context, writer);
        return writer.toString();
    }

    /**
     * Get the email template for contact message which sent from user to merchant
     * @param vo
     * @return
     */
    public static String userContactMsgTemplate(UserContactEmailVO vo) {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty("resource.loader", "class");
        ve.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        ve.init();
        VelocityContext context = new VelocityContext();
        context.put("userContactEmailVO", vo);

        /*
         *   get the Template
         */

        Template t = ve.getTemplate("vm/userContactMerchant.vm");

        /*
         *  now render the template into a Writer, here
         *  a StringWriter
         */

        StringWriter writer = new StringWriter();

        t.merge(context, writer);
        return writer.toString();
    }
}
