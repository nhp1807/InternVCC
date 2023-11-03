package data;

import java.util.Collection;
import java.util.Vector;

public class VectorExercise {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("First");
        vector.add("Second");
        vector.add(1, "Third");
        Collection<String> collection = new Vector<>();
        collection.add("Collect1");
        collection.add("Collect1");

        System.out.println(vector.capacity());  //Return 10 by default
        System.out.println(vector.get(1));
        vector.addAll(collection);
        System.out.println(vector.toString());
        System.out.println(vector.indexOf("Collect1"));
        System.out.println(vector.lastIndexOf("Collect1"));
//        vector.retainAll(collection);
//        System.out.println(vector);
    }
}
