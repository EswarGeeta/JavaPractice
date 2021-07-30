package org.practice.threads;

class Print implements Runnable{
	private static final Object lock = new Object();
	private static int in = 1;
	private final int reminder;

	public Print(int reminder) {
		this.reminder = reminder;
	}

	@Override
	public void run() {
		String thName = Thread.currentThread().getName();
		while(in < 20) {
			synchronized(lock) {
				while(in % 2 != reminder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				System.out.println(thName + in++);
				lock.notifyAll();
			}

		}			
	}
}

public class PrintIntegersWithThreads {
	
	public static void main(String[] args) {
		Thread even = new Thread(new Print(0), "EVEN");
		Thread odd = new Thread(new Print(1), "ODD");
		odd.start();
		even.start();


		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Implementing runnbale with out lambda");
			}
		};
		Runnable runnable1 = () -> {
			System.out.println("Implementing runnable with lambda");
		};
	}

}
