package pl.piotr.email.sender;

import pl.piotr.email.reader.AttachmentReader;
import pl.piotr.email.reader.ContentReader;
import pl.piotr.email.reader.PropertiesReader;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MailSender {

    public static void sendMail(String recipient) {
        System.out.println("\nSending to: " + recipient);

        Properties accountProp = PropertiesReader.getAccountProp();
        String myAccountEmail = accountProp.getProperty("account.email");
        String password = accountProp.getProperty("password");

        Properties smtpProp = PropertiesReader.getSmtpProp();

        Session session = Session.getInstance(smtpProp, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recipient);

        try {
            Transport.send(message);
            System.out.println("Message was correctly sent");
        } catch (Exception e) {
            System.out.println("Message wasn't sent");
            System.out.println(e.getMessage());
            System.out.println(e.getCause().getMessage());
        }
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Subject");

            String content = ContentReader.getContent();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(content);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);


            Map<String, String> attachments = AttachmentReader.getAttachments();
            for (String fileName : attachments.keySet()) {
                String fileUrl = attachments.get(fileName);
                DataSource source = new FileDataSource(fileUrl);
                messageBodyPart = new MimeBodyPart();
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(fileName);
                multipart.addBodyPart(messageBodyPart);
            }

            message.setContent(multipart);
            return message;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
