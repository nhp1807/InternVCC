package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriteExersice {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("src/file/buffer.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("Xin chao");
        bufferedWriter.close();
        fileWriter.close();
    }
}
