package exercise1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1 {
    public static void main(String[] args) {
        Set<Integer> set1 = generateRandomSet(2000000);
        Set<Integer> set2 = generateRandomSet(2000000);

        long start = System.nanoTime();

//        Set<Integer> intersection = new HashSet<>(set1);
//        intersection.retainAll(set2);

        Set<Integer> intersection1 = set1.stream().filter(set2::contains).collect(Collectors.toSet());

//        Set<Integer> union = new HashSet<>(set1);
//        union.addAll(set2);
        Set<Integer> union = union(set1, set2);

        long end = System.nanoTime();

        long times = TimeUnit.NANOSECONDS.toMillis(end - start);

//        System.out.println("Intersection: " + intersection.size());
        System.out.println("Intersection: " + intersection1.size());
        System.out.println("Union: " + union.size());
        System.out.println("Time: " + times);
    }

    private static Set<Integer> generateRandomSet(int size) {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        while (set.size() < size) {
//            set.add((int) (Math.random() * Integer.MAX_VALUE));
            set.add(random.nextInt(35000000));
        }
        return set;
    }

    private static Set<Integer> union(Set<Integer> set1, Set<Integer> set2){
        return Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet());
    }
}
