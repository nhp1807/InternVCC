package others.innerclass;

abstract class Person{
    abstract void eat();
}

interface Shape{
    void display();
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Person p = new Person() {
            @Override
            void eat() {
                System.out.println("Eating ...");
            }
        };

        p.eat();

        Shape s = new Shape() {
            @Override
            public void display() {
                System.out.println("Display shape");
            }
        };

        s.display();
    }
}
