package com.sau.corejava.thread.executer.ThreadPoolExecuter;

//A simple example that uses an Executor.

/*
As the output shows, even though the thread pool contains only two threads, all four tasks
are still executed. However, only two can run at the same time. The others must wait until
one of the pooled threads is available for use.
The call to shutdown( ) is important. If it were not present in the program, then the
program would not terminate because the executor would remain active. To try this for
yourself, simply comment out the call to shutdown( ) and observe the result.
*/

import java.util.concurrent.*;

class ThreadPoolExecuterDemo {
	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(5);
		CountDownLatch cdl2 = new CountDownLatch(5);
		CountDownLatch cdl3 = new CountDownLatch(5);
		CountDownLatch cdl4 = new CountDownLatch(5);
		ExecutorService es = Executors.newFixedThreadPool(2);
		System.out.println("Starting");
		// Start the threads.
		es.execute(new MyThread(cdl, "A"));
		es.execute(new MyThread(cdl2, "B"));
		es.execute(new MyThread(cdl3, "C"));
		es.execute(new MyThread(cdl4, "D"));
		try {
			cdl.await();
			cdl2.await();
			cdl3.await();
			cdl4.await();
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		es.shutdown();
		System.out.println("Done");
	}
}

class MyThread implements Runnable {
	String name;
	CountDownLatch latch;

	MyThread(CountDownLatch c, String n) {
		latch = c;
		name = n;
		new Thread(this);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": " + i);
			latch.countDown();
		}
	}
}