package stream.optional;

import java.util.List;
import java.util.Optional;

class Person{
    Address address;

    public Person(Address address) {
        this.address = address;
    }

    public Address getAddress(){
        return this.address;
    }
}

class Address{
    String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet(){
        return this.street;
    }
}

public class OptionalExercise {
    public static Person getPerson() {
        return new Person(new Address("Cau Giay"));
    }

    public static void main(String[] args) {
        // Empty optional object
        Optional<String> optional = Optional.empty();
        // Init value for optional object
        String str = "Phong";
        Optional<String> optional1 = Optional.of(str);
        System.out.println(optional1.get());

        List listStr = List.of("Hello", "Phong", 20207624);
        Optional<List<String>> optional2 = Optional.ofNullable(listStr);

        System.out.println(optional2);

        Optional<Person> person = Optional.of(getPerson());
        String streetName = person.map(Person::getAddress).map(Address::getStreet).orElse("Unkown");
        System.out.println(streetName);

        // Filter
        Optional<String> name = Optional.of("Phong");
        Optional<String> empty = Optional.empty();

        System.out.println(name.filter(n -> n.equals("PhOnG")).orElse("Empty"));
        System.out.println(name.filter(n -> n.equalsIgnoreCase("PhOnG")).orElse("Empty"));
    }
}