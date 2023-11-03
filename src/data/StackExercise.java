package data;

import java.util.Stack;

public class StackExercise {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(7);
        stack.push(5);
        System.out.println(stack.get(1));
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.add(5);
        System.out.println(stack.capacity());   //Return 10 by default
        System.out.println(stack.elementAt(2) + " " + stack.get(2));

    }
}
