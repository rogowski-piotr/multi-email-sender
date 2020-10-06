package pl.piotr.email.reader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AttachmentReader extends Reader {

    public static Map<String, String> getAttachments() {
        Map<String, String> files = new HashMap<>();
        File directory = new File(PATH_TO_ATTACHMENTS);

        if (! directory.exists()) {
            System.out.println("Miss a file from \n" + PATH_TO_ATTACHMENTS);
            return files;
        }

        String [] fileArray = directory.list();

        for (String fileName : fileArray) {
            String filePath = PATH_TO_ATTACHMENTS + "/" + fileName;
            files.put(fileName, filePath);
        }
        return files;
    }

}
