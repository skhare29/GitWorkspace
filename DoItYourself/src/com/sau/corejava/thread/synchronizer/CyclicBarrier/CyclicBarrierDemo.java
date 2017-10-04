package com.sau.corejava.thread.synchronizer.CyclicBarrier;

//An example of CyclicBarrier.
import java.util.concurrent.*;

class CyclicBarrierDemo {
	public static void main(String args[]) {
		CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
		System.out.println("Starting");
		new MyThread(cb, "A");
		new MyThread(cb, "B");
		new MyThread(cb, "C");
		
		//Uncomment below section to check the behavior
		
/*		try {
			cb.await();
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Demonstrating that CyclicBarrier can be reused
		new MyThread(cb, "E");
		new MyThread(cb, "F");
		new MyThread(cb, "G");
		
		System.out.println("Done");
	}
}

// A thread of execution that uses a CyclicBarrier.
class MyThread implements Runnable {
	CyclicBarrier cbar;
	String name;

	MyThread(CyclicBarrier c, String n) {
		cbar = c;
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println(name);
		try {
			cbar.await();
		} catch (BrokenBarrierException exc) {
			System.out.println(exc);
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		System.out.println("Thread Name: " + name);
	}
}

// An object of this class is called when the
// CyclicBarrier ends.
class BarAction implements Runnable {
	public void run() {
		System.out.println("Barrier Reached!");
	}
}