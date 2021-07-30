package org.practice.threads;

import java.util.ArrayList;
import java.util.Random;

public class HackerThreads {

    public static final int MAX_PASSWORD = 9999;
    public static void main(String[] args) {
        Random rand = new Random();
        int password = rand.nextInt(MAX_PASSWORD);
        Vault valut = new Vault(password);

        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerThread(valut));
        threads.add(new DescendingHackerThread(valut));
        threads.add(new PoliceThread());
        threads.forEach(Thread::start);
    }

    private static class Vault {
        private final int secret;
        public Vault(int secret) {
            this.secret = secret;
        }
        public boolean isCorrectPassword(int guess) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return secret == guess;
        }
    }

    private static abstract class HackerThread extends Thread {
        private final Vault vault;
        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        public Vault getVault() {
            return vault;
        }

        @Override
        public synchronized void start() {
            System.out.println("Started the thread" + this.getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackerThread {
        public AscendingHackerThread(Vault vault) {
            super(vault);
        }
        @Override
        public void run() {
            for(int i=0; i < MAX_PASSWORD; i++) {
                if(this.getVault().isCorrectPassword(i)) {
                    System.out.print("Guessed the password " + i + " from thread " + this.getName());
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingHackerThread extends HackerThread {
        public DescendingHackerThread(Vault vault) {
            super(vault);
        }
        @Override
        public void run() {
            for(int i = MAX_PASSWORD; i > 0; i--) {
                if(this.getVault().isCorrectPassword(i)) {
                    System.out.print("Guessed the password " + i + " from thread " + this.getName());
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {
        public PoliceThread() {
            this.setName(this.getClass().getName());
        }
        @Override
        public void run() {
            System.out.println("Started Thread: " + this.getName());

            for(int i=10; i>=0; i--) {
                try {
                    Thread.sleep(1000);
                    System.out.println(i + " seconds left for hackers to guess password");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Your game is over Hackers");
            System.exit(0);
        }
    }
}
