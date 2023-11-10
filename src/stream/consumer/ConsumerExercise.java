package stream.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Programing {
    public String language;
    public int experience;

    public Programing(String language, int experience) {
        this.language = language;
        this.experience = experience;
    }

    public void print() {
        System.out.println("Language: " + language + " - Experience: " + experience);
    }
}

public class ConsumerExercise {
    public static final int TEST_NUMBER = 5;
    static void printValue(String value){
        System.out.println("Hello, " + value);
    }

    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello, " + s);
            }
        };

        consumer.accept("Phong");

        Consumer<String> consumer1 = (name) -> {
            System.out.println("Hello, " + name);
        };

        consumer1.accept("Phong");

        Consumer<String> consumer2 = ConsumerExercise::printValue;
        consumer2.accept("Phong");

        Consumer<Integer> times2 = (e) -> System.out.println(e * 2);
        Consumer<Integer> squared = (e) -> System.out.println(e * e);
        Consumer<Integer> isOdd = (e) -> System.out.println(e % 2 == 1);

        // perform every consumer
        times2.accept(TEST_NUMBER); // 10
        squared.accept(TEST_NUMBER); // 25
        isOdd.accept(TEST_NUMBER); // true

        // perform 3 methods in sequence
        Consumer<Integer> combineConsumer = times2.andThen(squared).andThen(isOdd);
        combineConsumer.accept(TEST_NUMBER); // 10 25 true

        List<Programing> list = new ArrayList<>();
        list.add(new Programing("Java", 5));
        list.add(new Programing("PHP", 2));
        list.add(new Programing("C#", 1));

        // Creating instance of Consumer functional interface
        Consumer<Programing> consumer3 = (p) -> System.out.println(
                "Name: " + p.language + " - Experience: " + p.experience);

        System.out.println("Using Consumer: ");
        list.forEach(consumer3);

        System.out.println("\nUsing Method Reference: ");
        list.forEach(Programing::print);

        System.out.println("\nUsing Lambda Expression: ");
        list.forEach(s -> s.print());
    }
}
