package concurrency_exercises.deadlock;

public class DeadLock {
    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    // ждём чтобы 2ой поток успел захватить монитор на объекте lock2
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {

                    System.out.println("Hello from t1");
                }
            }
        }, "Thread1");

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                synchronized (lock1) {

                    System.out.println("Hello from t2");
                }
            }
        }, "Thread2");

        t1.start();
        t2.start();
    }
}
