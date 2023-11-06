package collections;

import java.util.*;

public class SortMapByValue {
    public static void main(String[] args) {
        // Tạo một Map với các cặp khóa-giá trị
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Alice", 25);
        unsortedMap.put("Bob", 30);
        unsortedMap.put("Charlie", 20);
        unsortedMap.put("David", 35);

        // Chuyển các cặp khóa-giá trị vào danh sách để sắp xếp
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(unsortedMap.entrySet());

        // Sắp xếp danh sách dựa trên giá trị (value)
        entryList.sort(Comparator.comparing(Map.Entry::getValue));

        // Tạo một LinkedHashMap mới từ danh sách đã sắp xếp
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // In ra Map đã sắp xếp theo giá trị
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}