package pl.piotr.email;

import java.util.List;

public class Main {

    public static void main(String [] args){
        List<String> emailAddresses = AddressesReader.getEmails();

        for (String email : emailAddresses) {
            MailSender.sendMail(email);
        }
    }
}