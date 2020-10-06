package pl.piotr.email.reader;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader extends Reader {

    public static Properties getAccountProp() {
        try {
            Properties accountProps = new Properties();
            accountProps.load(new FileInputStream(PATH_TO_ACCOUNT_CONFIG));
            return accountProps;
        } catch (Exception e) {
            System.out.println("Miss a properties file from \n" + PATH_TO_ACCOUNT_CONFIG); }

        return null;
    }

    public static Properties getSmtpProp() {
        try {
            Properties smtpProps = new Properties();
            smtpProps.load(new FileInputStream(PATH_TO_SMTP_CONFIG));
            return smtpProps;
        } catch (Exception e) {
            System.out.println("Miss a properties file from \n" + PATH_TO_SMTP_CONFIG); }

        return null;
    }
}
