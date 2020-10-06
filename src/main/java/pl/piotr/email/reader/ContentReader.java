package pl.piotr.email.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContentReader extends Reader {

    public static String getContent() {
        Path filePath = Paths.get(PATH_TO_CONTENT);

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
