package oop;

public class InstanceOf {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student instanceof Person);
        System.out.println(student instanceof Animals);
    }
}
