package com.sau.corejava.thread.synchronizer.semaphore;

//An implementation of a producer and consumer
//that use semaphores to control synchronization.
import java.util.concurrent.Semaphore;

class SemDemoProduserCosumerExample {
	public static void main(String args[]) {
		Q q = new Q();
		new Consumer(q);
		new Producer(q);
	}
}

class Q {
	int n;
	
	// Start with consumer semaphore unavailable.
	// Notice that semCon is initialized with no available permits. This ensures that put( )
	// executes first. The ability to set the initial synchronization state is one of the more powerful
	// aspects of a semaphore
	static Semaphore semCon = new Semaphore(0);
	static Semaphore semProd = new Semaphore(1);

	void get() {
		try {
			semCon.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		System.out.println("Got: " + n);
		semProd.release();
	}

	void put(int n) {
		try {
			semProd.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		this.n = n;
		System.out.println("Put: " + n);
		semCon.release();
	}
}

class Producer implements Runnable {
	Q q;

	Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}

	public void run() {
		for (int i = 0; i < 20; i++)
			q.put(i);
	}
}

class Consumer implements Runnable {
	Q q;

	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		for (int i = 0; i < 20; i++)
			q.get();
	}
}

