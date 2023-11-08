package lambdaExpression;

public class LambdaExercise {
    @FunctionalInterface
    interface Hello{
        public String sayHello(String name);
//        public String sayHello();
    }
    public static void main(String[] args) {
//        Hello s = () -> {
//            return "Hello Lambda.";
//        };

        Hello s = name -> {
            return "Hello " + name;
        };

        System.out.println(s.sayHello("Phong"));
    }
}
