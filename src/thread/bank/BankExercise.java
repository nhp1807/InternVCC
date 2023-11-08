package thread.bank;

public class BankExercise {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Thread thread1 = new Thread(){
            public void run(){
                customer.withdraw(2000);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                customer.withdraw(2600);
            }
        };
        thread1.start();

        Thread thread2 = new Thread(){
            public void run(){
                customer.deposit(500);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                customer.deposit(3000);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                customer.deposit(200);
            }
        };
        thread2.start();
    }
}
