package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExceptionExercise {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        String s = sc.nextLine();
        try{
            int x = 9;
            int y = 0;
            int z = x/y;
        }catch (ArithmeticException e){
            throw new ArithmeticException();
        }finally {
            System.out.println("This is finally block");
        }

//        System.out.println(z);

//        FileReader fileReader = new FileReader("a.txt");
    }
}
