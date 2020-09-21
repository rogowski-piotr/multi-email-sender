package pl.piotr.email;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContentReader {

    public static String getContent() {
        String path = System.getProperty("user.dir");
        Path filePath = Paths.get(path + "/properties/content.txt");

        try {
            String data = new String(Files.readAllBytes(filePath));
            return data;
        } catch (IOException e) {
            System.out.println("Can not read the content file from: \n" + filePath.toString());
            System.out.println(e.getMessage());
        }
        return null;
    }

}
