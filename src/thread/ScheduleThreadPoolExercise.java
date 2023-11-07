package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolExercise {
    public static void main(String[] args) throws InterruptedException {
        // Tạo một ScheduledThreadPoolExecutor với 2 luồng
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Tác vụ sẽ chạy sau 2 giây lần đầu tiên và sau đó mỗi 5 giây
        Runnable task = () -> {
            System.out.println("Tác vụ được thực hiện.");
        };
        executor.scheduleWithFixedDelay(task, 2, 5, TimeUnit.SECONDS);

        Thread.sleep(20000);
        // Ngừng lên lịch và kết thúc Executor
        executor.shutdown();
    }
}
