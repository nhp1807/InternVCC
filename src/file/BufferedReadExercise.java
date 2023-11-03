package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReadExercise {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/file/buffer.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int ch;
        while ((ch=bufferedReader.read()) != -1){
            System.out.print((char) ch);
        }
    }
}
