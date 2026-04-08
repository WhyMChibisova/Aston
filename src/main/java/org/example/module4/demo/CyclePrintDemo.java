package org.example.module4.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CyclePrintDemo implements ThreadDemo {
    private final Semaphore semaphore1 = new Semaphore(1);
    private final Semaphore semaphore2 = new Semaphore(0);

    @Override
    public void demonstrate() {
        Thread thread1 = new Thread(new CyclePrint(semaphore1, semaphore2, 1), "Thread-1");
        Thread thread2 = new Thread(new CyclePrint(semaphore2, semaphore1, 2), "Thread-2");

        System.out.println("Start cycle print");
        thread1.start();
        thread2.start();

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }

        thread1.interrupt();
        thread2.interrupt();
        System.out.println("Finish cycle print");
    }

    private static class CyclePrint implements Runnable {
        private final Semaphore semaphore1;
        private final Semaphore semaphore2;
        private final int number;

        public CyclePrint(Semaphore semaphore1, Semaphore semaphore2, int number) {
            this.semaphore1 = semaphore1;
            this.semaphore2 = semaphore2;
            this.number = number;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    semaphore1.acquire();
                    System.out.println(number);
                    TimeUnit.MILLISECONDS.sleep(100);
                    semaphore2.release();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " is interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
