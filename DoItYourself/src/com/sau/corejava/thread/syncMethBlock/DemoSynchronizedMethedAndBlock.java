package com.sau.corejava.thread.syncMethBlock;

public class DemoSynchronizedMethedAndBlock {

	public static void main(String args[]) {
		
		
//		Using Same Object of callMe		
//		Callme target = new Callme();
//		Caller ob1 = new Caller(target, "Hello");
//		Caller ob2 = new Caller(target, "Synchronized");
//		Caller ob3 = new Caller(target, "World");
		
//		Using different Object of callMe			
		Caller ob1 = new Caller(new Callme(), "Hello");
		Caller ob2 = new Caller(new Callme(), "Synchronized");
		Caller ob3 = new Caller(new Callme(), "World");
		
		// wait for threads to end
		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
}

//synchronized class Callme {
class Callme {
	void call(String msg) {

		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	String msg;
	Callme target;
	Thread t;

	public Caller(Callme targ, String s) {
		target = targ;
		msg = s;
		t = new Thread(this);
		t.start();
	}

	// synchronize calls to call() using class level lock
	public void run() {
		synchronized (Callme.class) { // synchronized block
			target.call(msg);
		}
	}
	
	
	// synchronize calls to call() using object level lock
//	public void run() {
//		synchronized (target) { // synchronized block
//			target.call(msg);
//		}
//	}
	
	
	// No synchronized calls
//	public void run() {
//
//			target.call(msg);
//
//	}
}
