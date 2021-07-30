package org.practice.threads;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample2 {

    /*
    1. Create Read thread
    2. Create Write thread
    Start multiple  read org.practice.threads and 1 write thread.
    Print the current count of locks and see the mutual exclusivity of read/write locks
     */

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static String sharedObject = "";


    public static void main(String[] args) {
        ReadThread readThread1 = new ReadThread();
        ReadThread readThread2 = new ReadThread();
        ReadThread readThread3 = new ReadThread();
        ReadThread readThread4 = new ReadThread();
        ReadThread readThread5 = new ReadThread();

        WriteThread writeThread = new WriteThread();

        readThread1.start();
        readThread2.start();
        writeThread.start();
        readThread3.start();
        readThread4.start();
        readThread5.start();
    }


    static class ReadThread extends Thread {
        @Override
        public void run() {
            lock.readLock().lock();
            try {
                System.out.println("Current read lock count: " + lock.getReadLockCount() + " and " + lock.getReadHoldCount());
                System.out.println(sharedObject);
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            lock.writeLock().lock();
            try {
                System.out.println("Current write lock count: " + lock.getWriteHoldCount());
                sharedObject = sharedObject.concat("X");
            } finally {
                lock.writeLock().unlock();
            }
        }
    }


}
