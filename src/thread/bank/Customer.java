package thread.bank;

public class Customer {
    private int balance = 1000;
    public Customer(){
        System.out.println("Tai khoan cua ban la: " + balance);
    }

    public synchronized void withdraw(int amount){
        System.out.println("Thuc hien rut tien");
        while(amount > balance){
            System.out.println("Khong du tien de rut!");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        balance = balance - amount;
        System.out.println("Rut tien thanh cong, so du hien tai: " + balance);
    }

    public synchronized void deposit(int amount){
        System.out.println("Thuc hien nap tien");
        balance += amount;
        System.out.println("Nap tien thanh cong, so du hien tai: " + balance);
        notify();
    }
}
