package concurrency_exercises.thread_step;

public class Step {

    private final Object lock = new Object();

    Thread thread1;
    Thread thread2;

    public void start() {
        thread1 = new Thread(this::step1);
        thread2 = new Thread(this::step2);

        thread1.start();
        thread2.start();
    }

    private void step1() {
        step(true);
    }

    private void step2() {
        step(false);
    }

    public void step(boolean isFlag) {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (lock) {

                    System.out.println(isFlag ? "Шаг 1" : "Шаг 2");

                    lock.notify();
                    Thread.sleep(100L);
                    lock.wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.printf("step = %s was interrupted..."
                    + System.lineSeparator(), isFlag);
        }
    }

    public void stop() {
        thread1.interrupt();
        thread2.interrupt();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}