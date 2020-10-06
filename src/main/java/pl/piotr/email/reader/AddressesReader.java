package pl.piotr.email.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressesReader extends Reader {

    public static List<String> getEmails() {
        File file = new File(PATH_TO_ADRESSES);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            List<String> addresess = new ArrayList<>();
            String address;

            while ((address = br.readLine()) != null)
                addresess.add(address);

            return addresess;
        } catch (IOException e) {
            System.out.println("Can not read the adresess list from: \n" + file.getPath());
            System.out.println(e.getMessage());
        }
        return null;
    }

}
