package oop;

import java.util.Hashtable;

public class HashTableExercise {
    public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>();

        table.put(1, "Phong");
        table.put(2, "Thai");
        table.put(3, "Doan");

        System.out.println(table.contains("Thai"));
        byte[] bytes = table.get(2).getBytes();
        for(byte b : bytes){
            System.out.print(b + " ");
        }
        System.out.println(table.get(2).hashCode());
    }
}
