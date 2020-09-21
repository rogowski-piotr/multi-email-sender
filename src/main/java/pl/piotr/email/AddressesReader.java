package pl.piotr.email;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressesReader {

    public static List<String> getEmails() {
        String path = System.getProperty("user.dir");
        File file = new File(path + "/properties/addresses.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            List<String> addresess = new ArrayList<String>();
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
