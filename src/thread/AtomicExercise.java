package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExercise {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Thread thread1 = new Thread(() -> {
           for (int i = 0; i < 10; i++){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               atomicInteger.incrementAndGet();
               System.out.println(atomicInteger.get());
           }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                atomicInteger.decrementAndGet();
                System.out.println(atomicInteger.get());
            }
        });

        thread1.start();
        thread2.start();

        System.out.println(atomicInteger.get());
    }
}
