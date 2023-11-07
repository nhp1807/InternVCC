package thread;

public class ThreadExercise extends Thread {
    public void run(){
        Thread t = Thread.currentThread();
//        System.out.println("Thread " + t.getName() + " is running...");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Thread " + t.getName() + " end");

        System.out.println("Running thread: " + t.getName());
        System.out.println("Priority is: "+ t.getPriority());

//        for(int i = 0; i < 5; i++){
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(i);
//        }
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadExercise obj1 = new ThreadExercise();
        ThreadExercise obj2 = new ThreadExercise();
//        ThreadExercise obj3 = new ThreadExercise();
        obj1.setPriority(Thread.MIN_PRIORITY);
        obj2.setPriority(Thread.MAX_PRIORITY);
        obj1.start();
        obj2.start();

    }
}
