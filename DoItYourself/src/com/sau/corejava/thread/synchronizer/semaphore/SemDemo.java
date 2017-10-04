package com.sau.corejava.thread.synchronizer.semaphore;

//A simple semaphore example.

/*The program uses a semaphore to control access to the count variable, which is a static
variable within the Shared class. Shared.count is incremented five times by the run( ) method
of IncThread and decremented five times by DecThread. To prevent these two threads from
accessing Shared.count at the same time, access is allowed only after a permit is acquired
from the controlling semaphore. After access is complete, the permit is released. In this
way, only one thread at a time will access Shared.count*/

/*
Conceptually, a semaphore maintains a set of permits. 
Each acquire() blocks if necessary until a permit is available, and then takes it. 
Each release() adds a permit, potentially releasing a blocking acquirer.
*/

import java.util.concurrent.*;

class SemDemo {
	public static void main(String args[]) {
		Semaphore sem = new Semaphore(1);
		//Try commenting above line and uncommenting below line to see the difference.
//		Semaphore sem = new Semaphore(2);
		new IncThread(sem, "A");

		new DecThread(sem, "B");
		Shared.count = 100;
	}
}

// A shared resource.
class Shared {
	static int count = 0;
}

// A thread of execution that increments count.
class IncThread implements Runnable {
	String name;
	Semaphore sem;

	IncThread(Semaphore s, String n) {
		sem = s;
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Starting " + name);
		try {
			// First, get a permit.
			System.out.println(name + " is waiting for a permit.");
			sem.acquire();
			System.out.println(name + " gets a permit.");
			// Now, access shared resource.
			for (int i = 0; i < 5; i++) {
				Shared.count++;
				System.out.println(name + ": " + Shared.count);
				// Now, allow a context switch -- if possible.
				Thread.sleep(10);
			}
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		// Release the permit.
		System.out.println(name + " releases the permit.");
		sem.release();
	}
}

// A thread of execution that decrements count.
class DecThread implements Runnable {
	String name;
	Semaphore sem;

	DecThread(Semaphore s, String n) {
		sem = s;
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Starting " + name);
		try {
			// First, get a permit.
			System.out.println(name + " is waiting for a permit.");
			sem.acquire();
			System.out.println(name + " gets a permit.");
			// Now, access shared resource.
			for (int i = 0; i < 5; i++) {
				Shared.count--;
				System.out.println(name + ": " + Shared.count);
				// Now, allow a context switch -- if possible.
				Thread.sleep(10);
			}
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		// Release the permit.
		System.out.println(name + " releases the permit.");
		sem.release();
	}
}
