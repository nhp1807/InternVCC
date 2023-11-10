package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

interface Calculator{
    int cal(int a, int b);
}
public class AtomicExercise {
    public static Integer total = 0;

    //    public static Object flag = new Object();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Object flag = new Object();

//        int total = 0;
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                        for (int j = 0; j < 1000; j++) {
                            synchronized (flag) {
                                total++;
                            }
                        }
                    }
            );
        }

        executorService.shutdown();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(total);

//        int a = 1, b =2;
        Calculator cal = (a, b) -> a + b;
        System.out.println(cal.cal(1,2));


    }
}
