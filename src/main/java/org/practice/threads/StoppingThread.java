package org.practice.threads;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

public class StoppingThread {


    public static void main(String[] args) {
        Thread computingThread = new Thread(new TimeConsumingComputation(BigDecimal.valueOf(20000), BigDecimal.valueOf(100000)));
        computingThread.start();


        /*
        Below interrupt signal won't have any impact unless the thread being interrupted looks for this signal periodically
        and stops the execution.
         */
        computingThread.interrupt();
    }


    @AllArgsConstructor
    static class TimeConsumingComputation implements Runnable{

        BigDecimal base;
        BigDecimal power;

        public BigDecimal computeResult() {
            BigDecimal result = base;
            for(BigDecimal i = BigDecimal.ONE ; i.compareTo(power) != 0 ; i = i.add(BigDecimal.ONE)) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("I got interrupted");
                    return BigDecimal.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }

        @Override
        public void run() {
            BigDecimal result = computeResult();
            System.out.println(result);
        }
    }
}
