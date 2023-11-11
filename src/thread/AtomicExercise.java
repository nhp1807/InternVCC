package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExercise {
    public static Integer total = 0;

    //    public static Object flag = new Object();
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Object flag = new Object();
//
////        int total = 0;
//        for (int i = 0; i < 10; i++) {
//            executorService.submit(() -> {
//                        for (int j = 0; j < 1000; j++) {
//                            synchronized (flag) {
//                                total++;
//                            }
//                        }
//                    }
//            );
//        }
//
//        executorService.shutdown();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(total);

        atomicFunc();
        withoutAotmic();
    }

    public static void atomicFunc(){
        AtomicInteger atomic = new AtomicInteger(0);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++){
                    atomic.incrementAndGet();
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Result: " + atomic.get());
    }

    public static void withoutAotmic(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++){
                    total++;
                    System.out.println(Thread.currentThread().getName() + " is running " + total);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();;
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Result: " + total);
    }
}
