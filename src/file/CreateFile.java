package file;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        try{
            File createFile = new File("src/file/file.txt");
            if (createFile.createNewFile()){
                System.out.println("Created file " + createFile.getName());
            }else {
                System.out.println("This file is already existed");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
