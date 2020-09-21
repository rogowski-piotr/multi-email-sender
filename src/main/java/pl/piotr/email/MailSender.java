package pl.piotr.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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

            MimeBodyPart attachPart = new MimeBodyPart();
            attachPart.attachFile("Path/To/Attach/File");
            multipart.addBodyPart(attachPart);

            message.setContent(multipart);

            return message;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
