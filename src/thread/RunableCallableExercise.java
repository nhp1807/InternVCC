package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RunableCallableExercise {
    public static void main(String[] args) {
        RunableFunc();
//        CallableFunc2();
    }

    public static void RunableFunc() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Running in runable...");
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void CallableFunc() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }

                return sum;
            }
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(callable);

        try {
            int result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }

    public static void CallableFunc2() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int threadId = i;
            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return threadId * 3;
                }
            };

            lists.add(task);
        }

        try {
            List<Future<Integer>> futures = executor.invokeAll(lists);
            List<Integer> results = new ArrayList<>();

            for (Future<Integer> result : futures) {
                try {
                    results.add(result.get());
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            executor.shutdown();
            System.out.println(results);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
