package com.sau.corejava.thread.threadGroup;

public class ThreadGroupDemo {

	public static void main(String[] args) {

		ThreadGroup grp = new ThreadGroup("group1");
		
		grp.setDaemon(true);
		
		mythread m1 = new mythread(grp, "thread1");
		mythread m2 = new mythread(grp, "thread2");
		mythread m3 = new mythread(grp, "thread3");
		
		
//		m1.setDaemon(true);
//		m2.setDaemon(true);
//		m3.setDaemon(true);
		
		m1.start();
		m2.start();
		m3.start();
		
		//grp.interrupt();
		
		System.out.println();
		
		System.out.println("Exiting....");
	}
}

class mythread extends Thread {
	public mythread(ThreadGroup g, String s) {
		super(g, s);
	}

	@Override
	public void run() {
		System.out.println("Thread group, prority, thread name " + Thread.currentThread());
//		try {
			while(true){}
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
