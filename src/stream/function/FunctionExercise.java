package stream.function;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

class User{
    String name;
    String email;
    String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

class Member{
    String name;
    String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Email: " + email;
    }
}

public class FunctionExercise {
    public static void main(String[] args) {
        System.out.println("- Convert string to integer");
        Function<String, Integer> numberConverter = (str) -> Integer.parseInt(str);
        System.out.println(numberConverter.apply("123"));

        System.out.println("- Convert local date to string");
        Function<LocalDate, String> dateConverter = (date) -> date.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
        System.out.println(dateConverter.apply(LocalDate.now()));

        System.out.println("- Convert User object to Member object");
        Function<User, Member> mapUserToMember = u -> new Member(u.name, u.email);

        System.out.println(mapUserToMember.apply(new User("Phong", "nhp1807@gmail.com", "haiphong123")).toString());

        System.out.println("- Convert list User object to list Member object");
        List<User> listUser = new ArrayList<>();
        User user1 = new User("User 1", "user1@gmail.com", "user1pass");
        User user2 = new User("User 2", "user2@gmail.com", "user2pass");
        User user3 = new User("User 3", "user3@gmail.com", "user3pass");
        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);

        List<Member> listMember = listUser.stream().map(mapUserToMember).collect(Collectors.toList());

        for (Member member : listMember){
            System.out.println(member.toString());
        }

        System.out.println("- Using some method");
        Function<Integer, Integer> times2 = n -> n * 2;
        Function<Integer, Integer> squared = n -> n * n;

        Function<Integer, Integer> andThen = times2.andThen(squared);
        System.out.println(andThen.apply(5));

        Function<Integer, Integer> compose = times2.compose(squared);
        System.out.println(compose.apply(5));

        System.out.println("- Some functional interfaces");
        IntFunction<String> ifunc = (x) -> Integer.toString(x * x);
        LongFunction<String> lfunc = (x) -> Long.toString(x * x);
        DoubleFunction<String> dfunc = (x) -> Double.toString(x * x);

        System.out.println(ifunc.apply(3)); // 9
        System.out.println(lfunc.apply(5)); // 25
        System.out.println(dfunc.apply(10)); // 100.0

        System.out.println("- BiFunction");
        BiFunction<String, String, String> biFunction1 = (s1, s2) -> s1 + s2;
        System.out.println(biFunction1.apply("nhp1807", "@gmail.com"));
    }
}
