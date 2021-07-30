package org.practice.threads;

public class Synchronisation {


    public static void main(String[] args) {

        SharableObject obj = new SharableObject(0);
        Thread t1 = new Thread(() -> {
            for(int i=0; i<10000 ; i++) {
                obj.incrementValue();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<10000 ; i++) {
                obj.decrementValue();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(obj.getValue());
    }

    private static class SharableObject {
        Object lock1 = new Object() ;
        Object lock2 = new Object();
        private int value;

        public SharableObject(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void incrementValue() {
            synchronized (lock1) {
                value++;
            }
        }

        public void decrementValue() {
            synchronized (lock2) {
                value--;
            }
        }


//        public synchronized void incrementValue() {
//            value++;
//        }
//
//        public synchronized void decrementValue() {
//            value--;
//        }
    }

}
