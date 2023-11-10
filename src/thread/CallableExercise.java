package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExercise {
    public static void main(String[] args) throws Exception {
        int numberOfThreads = 5;

        // Tạo một ExecutorService với số luồng cố định
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        List<Callable<Integer>> tasks = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            int threadNumber = i;
            Callable<Integer> task = () -> {
                System.out.println("Thread " + threadNumber + " is running.");
                return threadNumber * 3;
            };
            tasks.add(task);
        }

        try {
            // Bắt đầu chạy các tác vụ và thu thập kết quả
            List<Future<Integer>> results = executor.invokeAll(tasks);
            // Thu thập kết quả từ các Future
            List<Integer> threadResults = new ArrayList<>();
            for (Future<Integer> result : results) {
                threadResults.add(result.get());
            }

            // Kết thúc ExecutorService
            executor.shutdown();

            // In kết quả
            System.out.println("Results from threads: " + threadResults);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
