package com.sau.corejava.thread.lock;

import java.util.concurrent.locks.*;

/*
The following program demonstrates the use of a lock. It creates two threads that access
a shared resource called Shared.count. Before a thread can access Shared.count, it must
obtain a lock. After obtaining the lock, Shared.count is incremented and then, before
releasing the lock, the thread sleeps. This causes the second thread to attempt to obtain the
lock. However, because the lock is still held by the first thread, the second thread must wait
until the first thread stops sleeping and releases the lock. The output shows that access to
Shared.count is, indeed, synchronized by the lock.
*/

class LockDemo {
	public static void main(String args[]) {
		ReentrantLock lock = new ReentrantLock();
		new LockThread(lock, "A");
		new LockThread(lock, "B");
	}
}

// A shared resource.
class Shared {
	static int count = 0;
}

// A thread of execution that increments count.
class LockThread implements Runnable {
	String name;
	ReentrantLock lock;

	LockThread(ReentrantLock lk, String n) {
		lock = lk;
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Starting " + name);
		try {
			// First, lock count.
			System.out.println(name + " is waiting to lock count.");
			lock.lock();
			System.out.println(name + " is locking count.");
			Shared.count++;
			System.out.println(name + ": " + Shared.count);
			// Now, allow a context switch -- if possible.
			System.out.println(name + " is sleeping.");
			Thread.sleep(1000);
		} catch (InterruptedException exc) {
			System.out.println(exc);
		} finally {
			// Unlock
			System.out.println(name + " is unlocking count.");
			lock.unlock();
		}
	}
}
