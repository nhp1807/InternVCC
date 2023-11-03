package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinaryFile {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("src/file/file.bin");
            String content = "This is an example binary content.";
            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
