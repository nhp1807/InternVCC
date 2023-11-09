package others.innerclass;

public class StaticNestedClass {
    static int data = 100;

    static class Static{
        static void msg(){
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        Static obj = new StaticNestedClass.Static();
        obj.msg();
        StaticNestedClass.Static.msg();
    }
}
