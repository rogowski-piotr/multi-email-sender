package pl.piotr.email.reader;

public abstract class Reader {

    final static String PATH = System.getProperty("user.dir");
    final static String PATH_TO_CONTENT = PATH + "/properties/content.txt";
    static final String PATH_TO_ADRESSES = System.getProperty("user.dir") + "/properties/addresses.txt";
    static final String PATH_TO_ACCOUNT_CONFIG = PATH + "/properties/account.properties";
    static final String PATH_TO_SMTP_CONFIG = PATH + "/properties/smtp.properties";
    static final String PATH_TO_ATTACHMENTS = PATH + "/properties/attachments";

}
