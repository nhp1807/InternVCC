package thread;

public class SynchronizedExercise {
    private int sharedCounter = 2;

    // Khối lệnh synchronized
    public synchronized void increment() throws InterruptedException {
//        Thread.sleep(500);
        sharedCounter++;
    }

    public synchronized void decrement() throws InterruptedException {
//        Thread.sleep(500);
        sharedCounter--;
    }

    public synchronized int getSharedCounter() {
        return sharedCounter;
    }

    public static void main(String[] args) {
        SynchronizedExercise example = new SynchronizedExercise();

        // Tạo một luồng tăng giá trị
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    example.increment();
//                    System.out.println("Increase: " + example.getSharedCounter());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Tạo một luồng giảm giá trị
        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    example.decrement();
//                    System.out.println("Decrease: " + example.getSharedCounter());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Shared counter: " + example.getSharedCounter());
    }
}
