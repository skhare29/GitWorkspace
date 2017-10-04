package com.sau.corejava.thread.waitnotify;

//A correct implementation of a producer and consumer.

/*Inside get( ), wait( ) is called. This causes its execution to suspend until Producer notifies
you that some data is ready. When this happens, execution inside get( ) resumes. After the
data has been obtained, get( ) calls notify( ). This tells Producer that it is okay to put more
data in the queue. Inside put( ), wait( ) suspends execution until Consumer has removed the
item from the queue. When execution resumes, the next item of data is put in the queue,
and notify( ) is called. This tells Consumer that it should now remove it.*/

//Correct Implementation
//class Q {
//	int n;
//	boolean valueSet = false;
//
//	synchronized int get() {
//		while (!valueSet)
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				System.out.println("InterruptedException caught");
//			}
//		System.out.println("Got: " + n);
//		valueSet = false;
//		notify();
//		return n;
//	}
//
//	synchronized void put(int n) {
//		while (valueSet)
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				System.out.println("InterruptedException caught");
//			}
//		this.n = n;
//		valueSet = true;
//		System.out.println("Put: " + n);
//		notify();
//	}
//}

// An incorrect implementation of a producer and consumer.
class Q {
	int n;

	synchronized int get() {
		System.out.println("Got: " + n);
		return n;
	}

	synchronized void put(int n) {
		this.n = n;
		System.out.println("Put: " + n);
	}
}

class Producer implements Runnable {
	Q q;

	Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}

	public void run() {
		int i = 0;
		while (true) {
			q.put(i++);
		}
	}
}

class Consumer implements Runnable {
	Q q;

	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		while (true) {
			q.get();
		}
	}
}

class PCFixed {
	public static void main(String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Control-C to stop.");
	}
}
