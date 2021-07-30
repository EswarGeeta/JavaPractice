package org.practice.threads;

public class Deadlock3 {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread("thread1") {
			public void run() {
				for(int i=1 ; i< 10 ; i+=2) {
					System.out.println(i);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Thread t2 = new Thread("thread2") {
			public void run() {
				for(int i=2 ; i< 10 ; i+=2) {
					System.out.println(i);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
	}
}
