package org.practice.threads;

import java.math.BigInteger;

public class ThreadInterruption {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                    System.out.print("interrupted");
                    }
                }
            }
        });
        thread.start();
        thread.interrupt();

        LongComputingTask task = new LongComputingTask(new BigInteger("2"), new BigInteger("2000"));

        // Marking a thread as daemon thread lets the main thread exits even before this thread is complete.
        task.setDaemon(true);
        task.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }


    private static class LongComputingTask extends Thread {
        private BigInteger base;
        private BigInteger pow;

        public LongComputingTask(BigInteger base, BigInteger pow) {
            this.base = base;
            this.pow = pow;
        }

        @Override
        public void run() {
            BigInteger result = base;
            for(  BigInteger i = BigInteger.ONE; i.compareTo(pow) != 0 ; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
                System.out.println(result);
                if(this.currentThread().isInterrupted()) {
                    System.out.println("Thread got interrupted, exiting now");
                    System.exit(0);
                }
            }

        }
    }
}
