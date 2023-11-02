package oop;

class Shape{
    public void area(){
        System.out.println("Area of shape");
    }
}

class Circle extends Shape{
    public void area(){
        System.out.println("Area of Circle");
    }
}
public class Polymorphism {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle();

        shape.area();
        circle.area();
    }
}
