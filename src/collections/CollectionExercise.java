package collections;

import java.util.*;

public class CollectionExercise {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        System.out.println("HashSet: " + hashSet.toString());

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(3);
        linkedHashSet.add(2);

        System.out.println("LinkedHashSet: " + linkedHashSet.toString());

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);

        System.out.println("TreeSet: " + treeSet.toString());

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(2, "Phong");
        hashMap.put(1, null);

        System.out.println("HashMap: " + hashMap.toString());

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(2, "Phong");
        linkedHashMap.put(1, "Doan");

        System.out.println("LinkedHashMap: " + linkedHashMap.toString());

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(2, "Phong");
        treeMap.put(1, "Doan");
        System.out.println("TreeMap: " + treeMap.toString());
        System.out.println(treeMap.get(2).compareTo("Long"));
    }
}
