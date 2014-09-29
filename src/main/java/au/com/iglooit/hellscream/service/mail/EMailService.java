package au.com.iglooit.hellscream.service.mail;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.properties.WebProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 7/09/2014
 * Time: 8:34 AM
 */
@Component
public class EMailService {
    private static final Logger LOG = LoggerFactory.getLogger(EMailService.class);

    public void sendQuoteEmail(QuoteEmailVO quoteEmailVO) {
        WebProperties webProperties = WebProperties.getInstance();
        String adminEmail = webProperties.get("admin.email");
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = EmailTemplateHelper.quoteMsgTemplate(quoteEmailVO);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(adminEmail));
            for (String address : quoteEmailVO.getToAddressList()) {
                LOG.info("send email to " + address);
                msg.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(address, "Dear customer"));
            }
            msg.setSubject("A new quote for you.");

            Multipart mp = new MimeMultipart();

            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(msgBody, "text/html");
            mp.addBodyPart(htmlPart);

            msg.setContent(mp);
            Transport.send(msg);

        } catch (AddressException e) {
            throw new AppX("Wrong address", e);
        } catch (MessagingException e) {
            throw new AppX("Wrong Message ", e);
        } catch (UnsupportedEncodingException e) {
            throw new AppX("Wrong Encode", e);
        }
    }

    /**
     * when user want to contact to the merchant, sending an email
     *
     * @param emailVO
     */
    public void sendUserContactEmail(UserContactEmailVO emailVO) {
        WebProperties webProperties = WebProperties.getInstance();
        String adminEmail = webProperties.get("admin.email");

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = EmailTemplateHelper.userContactMsgTemplate(emailVO);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(adminEmail));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(emailVO.getToAddress(), "Mr. User"));
            msg.setSubject("You have a new client who want to talk with you!");
            msg.setText(msgBody);
            Transport.send(msg);

        } catch (AddressException e) {
            throw new AppX("Wrong address", e);
        } catch (MessagingException e) {
            throw new AppX("Wrong Message ", e);
        } catch (UnsupportedEncodingException e) {
            throw new AppX("Wrong Encode", e);
        }
    }

    public void sendContactUsEmail(ContactUsEmailVO vo) {
        WebProperties webProperties = WebProperties.getInstance();
        String adminEmail = webProperties.get("admin.email");

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = vo.getContent();

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(vo.getUserEmail()));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(adminEmail, vo.getName()));
            msg.setSubject("You get email from customer.");
            msg.setText(msgBody);
            Transport.send(msg);

        } catch (AddressException e) {
            throw new AppX("Wrong address", e);
        } catch (MessagingException e) {
            throw new AppX("Wrong Message ", e);
        } catch (UnsupportedEncodingException e) {
            throw new AppX("Wrong Encode", e);
        }
    }
}
