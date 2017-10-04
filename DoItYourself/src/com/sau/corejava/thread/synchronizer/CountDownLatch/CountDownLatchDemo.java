package com.sau.corejava.thread.synchronizer.CountDownLatch;

//An example of CountDownLatch.

/*
Inside main( ), a CountDownLatch called cdl is created with an initial count of five.
Next, an instance of MyThread is created, which begins execution of a new thread. Notice
that cdl is passed as a parameter to MyThread’s constructor and stored in the latch instance
variable. Then, the main thread calls await( ) on cdl, which causes execution of the main
thread to pause until cdl’s count has been decremented five times.
Inside the run( ) method of MyThread, a loop is created that iterates five times. With
each iteration, the countDown( ) method is called on latch, which refers to cdl in main( ).
After the fifth iteration, the latch opens, which allows the main thread to resume.
*/

import java.util.concurrent.CountDownLatch;

class CountDownLatchDemo {
	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(5);
		System.out.println("Starting");
		new MyThread(cdl, "A");
		new MyThread(cdl, "B");
		try {
			cdl.await();
			System.out.println("Pre Done");
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		System.out.println("Done");
	}
}

class MyThread implements Runnable {
	CountDownLatch latch;
	String name;

	MyThread(CountDownLatch c, String name) {
		this.latch = c;
		this.name = name;
		new Thread(this, name).start();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			System.out.println("Tread Name: " + name + " " + latch.getCount()); // decrement count
			try {
				if(Thread.currentThread().getName().equals("A"))
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
		}
	}
}