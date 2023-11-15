package exercise1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/exercise1/input_2/01.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

//        int ch;
//        while ((ch=bufferedReader.read()) != -1){
//            System.out.print((char) ch);
//        }

        // Tạo StringBuilder lưu nội dung của văn bản
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }

        // Đóng tệp văn bản
        bufferedReader.close();

        countWord(content.toString());
    }

    public static void countWord(String content){
        StringTokenizer stringTokenizer = new StringTokenizer(content, ".,!=+- ");
        HashMap<String, Integer> map = new HashMap<>();

        while (stringTokenizer.hasMoreTokens()){
            String word = stringTokenizer.nextToken();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        try {
            FileWriter fileWriter = new FileWriter("src/exercise1/input_2/output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue());
                bufferedWriter.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
