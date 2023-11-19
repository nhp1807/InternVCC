package exercise1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex3 {
    public static void main(String[] args) {
        // Đường dẫn đến thư mục chứa các file cần đọc
        String folderPath = "src/exercise1/input_3";

        // Tạo ExecutorService với số luồng cho phép
        ExecutorService executor = Executors.newFixedThreadPool(6);

        // Danh sách các Future để lưu trữ kết quả từ các nhiệm vụ
        List<Future<Map<String, Integer>>> futures = new ArrayList<>();

        // Lấy danh sách các file trong thư mục
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            // Duyệt qua từng file và tạo Callable để đếm tần suất xuất hiện của từng từ
            for (File file : files) {
                if (file.isFile()) {
                    Callable<Map<String, Integer>> wordCounterTask = () -> {
                        Map<String, Integer> wordFrequency = new HashMap<>();
                        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] words = line.split("\\s+"); // Tách các từ trong dòng
                                for (String word : words) {
//                                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Chuẩn hóa từ

                                    if (!word.isEmpty()) {
                                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return wordFrequency;
                    };

                    // Submit Callable đếm tần suất xuất hiện của từng từ vào ExecutorService và lưu trữ Future
                    Future<Map<String, Integer>> future = executor.submit(wordCounterTask);
                    futures.add(future);
                }
            }

            // Tạo một Map tổng hợp kết quả từ tất cả các Future
            Map<String, Integer> totalWordFrequency = new HashMap<>();
            for (Future<Map<String, Integer>> future : futures) {
                try {
                    Map<String, Integer> wordFrequency = future.get(); // Lấy kết quả từ Future (đợi nếu cần)
                    // Cộng dồn tần suất xuất hiện của từng từ từ các file
                    wordFrequency.forEach((key, value) -> totalWordFrequency.merge(key, value, Integer::sum));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Sắp xếp Map theo giá trị (tần suất xuất hiện của từ)
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(totalWordFrequency.entrySet());

            sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
//            sortedList.sort(Map.Entry.comparingByValue());

            // Lấy ra 10 từ có tần suất xuất hiện cao/thấp nhất
            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedList) {
                if (count < 10) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                    count++;
                } else {
                    break;
                }
            }

            // Đóng ExecutorService sau khi hoàn thành
            executor.shutdown();
        }
    }
}
