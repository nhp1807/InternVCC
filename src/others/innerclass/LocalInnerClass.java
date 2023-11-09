package others.innerclass;

public class LocalInnerClass {
    private int data = 100;

    void display(){
        class Local{
            void msg(){
                System.out.println(data);
            }
        }

        Local local = new Local();
        local.msg();
    }

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.display();
    }
}
