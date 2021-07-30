package org.practice.threads;

public class DeadLock2 {

    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();
        FirstThread firstThread = new FirstThread(sharedObject);
        SecondThread secondThread = new SecondThread(sharedObject);
        firstThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class FirstThread extends Thread {
        private SharedObject sharedObject;
        public FirstThread(SharedObject sharedObject) {
            this.sharedObject = sharedObject;
        }

        @Override
        public void run() {
            sharedObject.acquireAandthenB();
        }
    }

    static class SecondThread extends Thread {
        private SharedObject sharedObject;
        public SecondThread(SharedObject sharedObject) {
            this.sharedObject = sharedObject;
        }

        @Override
        public void run() {
            sharedObject.acquireBandthenA();
        }
    }

    static class SharedObject {
        Object lockA = new Object();
        Object lockB = new Object();

        public void acquireAandthenB() {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + ": Acquired A, going to acquire B");
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + ": Acquired B");
                    System.out.println(Thread.currentThread().getName() + ": and this is some computation with A and B");
                }
            }
        }

        public void acquireBandthenA() {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + ": Acquired B, going to acquire A");
                synchronized (lockA) {
                    System.out.println(Thread.currentThread().getName() + ": Acquired A");
                    System.out.println(Thread.currentThread().getName() + ": and this is some computation with A and B");
                }
            }
        }

    }
}
