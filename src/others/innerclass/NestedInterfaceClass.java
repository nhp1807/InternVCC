package others.innerclass;

interface Showable{
    void show();

    interface Message{
        void msg();
    }
}
public class NestedInterfaceClass implements Showable.Message {

    @Override
    public void msg() {
        System.out.println("Message");
    }

    public static void main(String[] args) {
        Showable obj = new Showable() {
            @Override
            public void show() {
                System.out.println("Show");
            }
        };

        obj.show();

        Showable.Message obj1 = new NestedInterfaceClass();
        obj1.msg();
    }
}
