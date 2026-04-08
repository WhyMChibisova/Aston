package org.example.module4.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockDemo implements ThreadDemo {
    private static final Lock LOCK_1 = new ReentrantLock();
    private static final Lock LOCK_2 = new ReentrantLock();
    private static final String THREAD_1_NAME = "Livelock-1";
    private static final String THREAD_2_NAME = "Livelock-2";

    @Override
    public void demonstrate() {
        Thread thread1 = new Thread(new Livelock(LOCK_1, LOCK_2, THREAD_1_NAME), THREAD_1_NAME);
        Thread thread2 = new Thread(new Livelock(LOCK_2, LOCK_1, THREAD_2_NAME), THREAD_2_NAME);

        System.out.println("Start livelock");
        thread1.start();
        thread2.start();

        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }

        thread1.interrupt();
        thread2.interrupt();
        System.out.println("Finish livelock");
    }

    private static class Livelock implements Runnable {
        private final Lock lock1;
        private final Lock lock2;
        private final String threadName;

        public Livelock(Lock lock1, Lock lock2, String threadName) {
            this.lock1 = lock1;
            this.lock2 = lock2;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            boolean firstLocked = false;
            boolean secondLocked = false;
            try {
                while ((!firstLocked || !secondLocked) && !Thread.currentThread().isInterrupted()) {
                    System.out.println(threadName + " try to lock " + getLockName(lock1));
                    if (firstLocked = lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println(threadName + " lock " + getLockName(lock1));

                            TimeUnit.MILLISECONDS.sleep(100);

                            System.out.println(threadName + " try to lock " + getLockName(lock2));
                            if (secondLocked = lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println(threadName + " lock " + getLockName(lock2));
                                } finally {
                                    lock2.unlock();
                                    System.out.println(threadName + " unlock " + getLockName(lock2));
                                }
                            } else {
                                TimeUnit.MILLISECONDS.sleep(100);
                            }
                        } finally {
                            lock1.unlock();
                            System.out.println(threadName + " unlock " + getLockName(lock1));
                        }
                    } else {
                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(threadName + " is interrupted");
                Thread.currentThread().interrupt();
            }
        }

        private String getLockName(Lock lock) {
            if (lock == LOCK_1) return "lock-1";
            if (lock == LOCK_2) return "lock-2";
            return "lock-unknown";
        }
    }
}