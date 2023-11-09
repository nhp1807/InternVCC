package others.generic;

import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    abstract void draw();
}

class Rectangle extends Shape {
    void draw() {
        System.out.println("ve hinh chu nhat.");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("ve hinh tron.");
    }
}

// Generic class
class MyGeneric<T> {
    T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }
}

public class GenericExercise {
    //Generic method
    public static <E> void printArray(E[] elements) {
        for (E e : elements) {
            System.out.print(e + " ");
        }
    }

    public static void drawShape(List<? extends Shape> list){
        for(Shape shape : list){
            shape.draw();
        }
    }

    public static void main(String[] args) {
        MyGeneric<Integer> integer = new MyGeneric<>();
        integer.set(1);
        integer.set(2);
//        System.out.println(integer.get());
        Integer[] listInt = new Integer[]{1, 2, 3, 4, 5, 6, 7};
//        printArray(listInt);

        List<Rectangle> rectangleList = new ArrayList<>();
        rectangleList.add(new Rectangle());

        List<Circle> circlesList = new ArrayList<>();
        circlesList.add(new Circle());
        circlesList.add(new Circle());

        drawShape(rectangleList);
        System.out.println();
        drawShape(circlesList);
    }
}
