package oop;

public class CustomHashFunction {
    public static int customHash(int a, int b, int c){
        int prime = 37;
        int result = 1;

        result = (result * prime) + a;
        result = (result * prime) + b;
        result = (result * prime) + c;

        return result;
    }

    public static void main(String[] args) {
        int a = 1, b = 3, c = 8;
        System.out.println("Hash code of " + a + ", " + b + ", " + c + " is : " + customHash(a,b,c));
    }
}
