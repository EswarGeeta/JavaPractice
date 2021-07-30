package org.practice.threads;

public class ThreadCreation {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
                System.out.println("Name of thread: " + Thread.currentThread().getName() + " and Priority of thread: " + Thread.currentThread().getPriority());
                throw new RuntimeException("Intentional exception");
            }
        );

        System.out.println("Name of parent thread: " + Thread.currentThread().getName());
        t1.setName("Sample thread");
        t1.setPriority(Thread.MAX_PRIORITY);

        // To handle any exception in org.practice.threads, we need to use below code
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("An exception occured in thread " + t.getName() + ". The error is: " + e.getMessage());
            }
        });
        t1.start();
        System.out.println("Name of parent thread: " + Thread.currentThread().getName());

        MyThread mt = new MyThread();
        mt.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.print("From this thread "+ this.getName());
        this.setName("MyThread");
        try {
            sleep(1000);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}