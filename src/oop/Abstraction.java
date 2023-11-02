package oop;

abstract class Animal{
    public abstract void action();
    public void sleep(){
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal{

    @Override
    public void action() {
        System.out.println("Dog does an action");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.action();
        dog.sleep();
    }
}
