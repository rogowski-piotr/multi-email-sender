package pl.piotr.email;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    public static Properties getAccountProp() {
        String path = System.getProperty("user.dir");
        String accountConfigPath = path + "/properties/account.properties";

        try {
            Properties accountProps = new Properties();
            accountProps.load(new FileInputStream(accountConfigPath));
            return accountProps;
        } catch (Exception e) {
            System.out.println("Miss a properties file from \n" + accountConfigPath ); }

        return null;
    }

    public static Properties getSmtpProp() {
        String path = System.getProperty("user.dir");
        String smtpConfigPath = path + "/properties/smtp.properties";

        try {
            Properties smtpProps = new Properties();
            smtpProps.load(new FileInputStream(smtpConfigPath));
            return smtpProps;
        } catch (Exception e) {
            System.out.println("Miss a properties file from \n" + smtpConfigPath ); }

        return null;
    }
}
