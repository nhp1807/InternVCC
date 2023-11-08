package stream;

@FunctionalInterface
interface ExecuteFunction{
    public int execute(int a, int b);
}

class MathUtils{
    public static int add(int a, int b){
        return a + b;
    }

    public static int minus(int a, int b){
        return a - b;
    }

    public int multi(int a, int b){
        return a * b;
    }
}

public class MethodRefference {
    public static int doAction(int a, int b, ExecuteFunction execute){
        return execute.execute(a, b);
    }

    public static void main(String[] args) {
        int a = 7;
        int b = 10;

        int sum = doAction(a, b, MathUtils::add);
        System.out.println("Sum is: " + sum);

        MathUtils obj1 = new MathUtils();
        int multi1 = doAction(a, b, obj1::multi);
        System.out.println("Multi is: " + multi1);
    }
}
