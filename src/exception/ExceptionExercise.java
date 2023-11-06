package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExceptionExercise {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
//        String s = sc.nextLine();
//        try{
////            int x = 9;
//            int y = 0;
////            int z = x/y;
//            if(true){
//                return;
//            }
//        }catch (ArithmeticException e){
//            throw new ArithmeticException();
//        }finally {
//            System.out.println("This is finally block");
//        }

//        System.out.println(z);

//        FileReader fileReader = new FileReader("a.txt");

        try {
            int data = 25;
            if (data % 2 != 0) {
                System.out.println(data + " is odd number");
                return;
            }
            System.out.println("after return");
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }
}
