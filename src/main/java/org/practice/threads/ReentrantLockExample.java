package org.practice.threads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(new WorkerThread(lock, "Job1"));
        threadPool.submit(new WorkerThread(lock, "Job2"));
        threadPool.submit(new WorkerThread(lock, "Job3"));
        threadPool.submit(new WorkerThread(lock, "Job4"));

        threadPool.shutdown();
    }

    static class WorkerThread implements Runnable {
        private Lock reentrantLock;
        public WorkerThread(Lock reentrantLock, String threadName) {
            this.reentrantLock = reentrantLock;
            Thread.currentThread().setName(threadName);
        }

        @Override
        public void run() {
            boolean workDone = false;
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            while(!workDone) {
                if(reentrantLock.tryLock()) {
                    try {
                        System.out.println("Lock is acquired by the Thread " + Thread.currentThread().getName() + " at "  + dateFormat.format(new Date()) );
                        Thread.sleep(100);
                        workDone = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        reentrantLock.unlock();
                    }
                } else {
                    System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for lock");
                }
            }
        }
    }


}
