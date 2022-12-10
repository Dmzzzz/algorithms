package concurrency_exercises.semafor;

import java.util.concurrent.Semaphore;

public class Main1 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        CheckSemaphore s1 = new CheckSemaphore();
        s1.semaphore = semaphore;

        CheckSemaphore s2 = new CheckSemaphore();
        s2.semaphore = semaphore;

        CheckSemaphore s3 = new CheckSemaphore();
        s3.semaphore = semaphore;

        CheckSemaphore s4 = new CheckSemaphore();
        s4.semaphore = semaphore;

        CheckSemaphore s5 = new CheckSemaphore();
        s5.semaphore = semaphore;

        s1.start();
        s2.start();
        s3.start();
        s4.start();
    }


    static class CheckSemaphore extends Thread {
       private Semaphore semaphore;

        @Override
        public void run() {
            System.out.println(this.getName() + " waiting for table");
            try {
                semaphore.acquire();
                System.out.println(this.getName() + " catch the table");
                this.sleep(1000L);
                System.out.println(this.getName() + " release table");

                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}