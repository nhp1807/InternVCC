package data;

import java.util.Stack;

public class NonRecursiveStack {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(n + "! is " + calculateFactorial(n));
    }

    public static long calculateFactorial(int n){
        long result = 1;
        Stack<Integer> stack = new Stack<>();

        while(n > 0){
            stack.push(n);
            n--;
        }

        while(!stack.empty()){
            result *= stack.pop();
        }

        return result;
    }
}
