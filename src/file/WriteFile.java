package file;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        try{
            FileWriter writeFile = new FileWriter("src/file/file.txt", true);
            writeFile.write("I am writing to this file\n");

            writeFile.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
