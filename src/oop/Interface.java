package oop;

interface Animals{
    void eat();
}

class Cat implements Animals{

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }
}

class Mouse implements Animals{

    @Override
    public void eat() {
        System.out.println("Mouse is eating");
    }
}

public class Interface {
    public static void main(String[] args) {
        Animals[] animals = new Animals[2];
        animals[0] = new Cat();
        animals[1] = new Mouse();

        for(Animals animal : animals){
            animal.eat();
        }
    }
}
