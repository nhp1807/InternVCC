package stream.defaultMethod;

interface IDBManager{
    void read();
    void write();
    default void log(String msg){
        System.out.println("LOG: " + msg);
    }
}

interface IAnotherDBManager extends IDBManager{
    public final int MAX_LOG_CHAR = 100;
    // Override default method from IDBManager
    default void log(String message){
        if (message.length() > MAX_LOG_CHAR){
            System.err.println("Message is too long!");
            return;
        }
        System.out.println("LOG: "+message);
    }
}

public class DefaultMethodExercise {
    public static void main(String[] args) {
        IAnotherDBManager obj = new IAnotherDBManager() {
            @Override
            public void read() {

            }

            @Override
            public void write() {

            }
        };

        obj.log("Hello");
    }
}
