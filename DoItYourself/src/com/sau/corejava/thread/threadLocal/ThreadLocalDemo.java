package com.sau.corejava.thread.threadLocal;

public class ThreadLocalDemo {

	public static class MyRunnable implements Runnable {

		private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		@Override
		public void run() {
			
			int num = (int) (Math.random() * 100D);
			
			System.out.println("Before " + Thread.currentThread().getName() + " num value " + num);
			
			threadLocal.set(num);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

			System.out.println("After " + Thread.currentThread().getName() + " num value " + threadLocal.get());
		}
	}

	public static void main(String[] args) {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread thread1 = new Thread(sharedRunnableInstance, "A");
		Thread thread2 = new Thread(sharedRunnableInstance, "B");

		thread1.start();
		thread2.start();

		try {
			thread1.join(); // wait for thread 1 to terminate
			thread2.join(); // wait for thread 2 to terminate
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}