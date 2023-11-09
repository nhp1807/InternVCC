package others.innerclass;

public class MemberInnerClass {
    private int data = 10;

    class Inner{
        void msg(){
            System.out.println("data is: " + data);
        }
    }

    public static void main(String[] args) {
        MemberInnerClass obj = new MemberInnerClass();
        MemberInnerClass.Inner inner = obj.new Inner();
        inner.msg();
    }
}
