package file;

import java.io.*;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args)  {
        int ch;
        try {
            FileReader fr = new FileReader("src/file/file.txt");
            while ((ch = fr.read()) != -1){
                System.out.print((char)ch);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
