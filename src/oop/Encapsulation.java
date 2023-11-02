package oop;

class Person{
    private String name;
    private int age;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person(){

    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String toString(){
        return "Name: " + name + "\nAge: " + age + "\nAddress: " + address;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Nguyen Hai Phong");
        person.setAge(21);
        person.setAddress("Hanoi");

    }
}
