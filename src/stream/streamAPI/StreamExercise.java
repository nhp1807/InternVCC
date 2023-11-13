package stream.streamAPI;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.*;

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }
}

class Student{
    private String name;
    private int age;
    private int id;

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nID: " + id;
    }
}

public class StreamExercise {
    public static void main(String[] args) {
        // Tạo stream kiểu primitive
        IntStream.range(1,5).forEach(e -> System.out.print(e + " "));
        System.out.println();
        IntStream.of(1,3,5,7).forEach(e -> System.out.print(e + " "));
        System.out.println();
        DoubleStream.of(1, 2, 3).forEach(e -> System.out.print(e + " "));
        System.out.println();
        LongStream.range(1, 4).forEach(e -> System.out.print(e + " "));
        System.out.println();
        LongStream.of(1, 2, 3).forEach(e -> System.out.print(e + " "));
        System.out.println();

        // Tạo stream từ các cấu trúc khác
        streamFromArray();
        System.out.println();
        streamFromCollection();
        System.out.println();
        streamFromGenerate();
        System.out.println();
        streamFromIterate();
        System.out.println();
        streamFromRegex();
        System.out.println();
        streamFilter();
        System.out.println();
        streamCount();
        System.out.println();
        streamSkip();
        System.out.println();
        streamMap();
        System.out.println();
        streamCollect();
        System.out.println();
        streamStatistics();
        System.out.println();
        streamNormal();
        System.out.println();
        streamParallel();
        System.out.println();
    }

    // Tạo stream từ Array
    public static void streamFromArray(){
        String[] languages = {"Java", "C", "C++", "C#", "Ruby", "Javascript"};

        Stream<String> stream = Arrays.stream(languages);
        stream.forEach(s -> System.out.print(s + " "));
    }

    // Tạo stream từ Collection
    public static void streamFromCollection(){
        List<String> item = List.of("Java", "C", "C++", "C#", "Ruby", "Javascript");
        item.forEach(s -> System.out.print(s + " "));
    }

    // Tạo stream từ Stream.generate()
    public static void streamFromGenerate(){
        Stream<String> stream = Stream.generate(() -> "Phong Nguyen").limit(3); // Add 3 times
        String[] testStrArr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(testStrArr));
    }

    // Tạo stream từ Stream.iterate()
    public static void streamFromIterate(){
        Stream<Long> longStream = Stream.iterate(1L, n -> n + 1).limit(5);
        longStream.forEach(e -> System.out.print(e + " "));
        System.out.println();
        Stream<Integer> intStream = Stream.iterate(1, i -> i <= 20, i -> i * 2);
        intStream.forEach(e -> System.out.print(e + " "));
    }

    // Tạo stream từ regex
    public static void streamFromRegex(){
        String str = "Welcome, Phong";
        Pattern.compile(",").splitAsStream(str).forEach(e -> System.out.print(e + " "));
    }

    // Filter()
    public static void streamFilter(){
        Stream<Integer> stream = Stream.iterate(1, i -> i + 2).filter(i -> i % 3 == 0).limit(6);
        stream.forEach(e -> System.out.print(e + " "));
    }

    // Count
    public static void streamCount(){
        Long count = Stream.iterate(1, i -> i + 2).limit(6).filter(i -> i % 3 == 0).count();
        System.out.println(count);
    }

    // Skip
    public static void streamSkip(){
        List<String> list = List.of("Java", "C++", "C#", "Python");
        list.stream().skip(2).forEach(e -> System.out.print(e + " "));
    }

    // Map
    public static void streamMap(){
        List<String> list = List.of("Java", "C++", "C#", "Python");
        list.stream().map(String::toUpperCase).forEach(e -> System.out.print(e + " "));

        List<Student> listStudent = new ArrayList<>();
        Student st1 = new Student("Phong", 21, 1);
        Student st2 = new Student("Thai", 20, 2);
        Student st3 = new Student("Doan", 22, 3);

        listStudent.add(st1);
        listStudent.add(st2);
        listStudent.add(st3);

        listStudent.stream().map(p -> new Person(p.getName(), p.getAge())).forEach(p -> System.out.println(p.toString()));
    }

    // Collect
    public static void streamCollect(){
        Stream<String> stream = Stream.of("Java", "C#", "C++", "PHP", "Javascript");
        List<String> languages = stream.collect(Collectors.toList());
        System.out.println(languages);
    }

    // GroupBy
    public static void streamGroupBy(){
        List<String> list = List.of("Java", "C++", "C#", "Python");
//        list.stream().
    }

    // Statistics
    public static void streamStatistics(){
        List<Integer> list = List.of(2,3,5,7,10);
        IntSummaryStatistics statistics = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("Max/Min: " + statistics.getMax() + "/" + statistics.getMin());
        System.out.println("Sum/Average: " + statistics.getSum() + "/" + statistics.getAverage());
    }

    public static void streamNormal(){
        List<String> values = createDummyData();

        long startTime = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    public static void streamParallel(){
        List<String> values = createDummyData();

        long startTime = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(String.format("parallel sort took: %d ms", millis));
    }

    public static List<String> createDummyData(){
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        return values;
    }
}
