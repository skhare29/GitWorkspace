package com.sau.corejava.thread.general;

public class MethodLevelLockOnStaticSyncMethod {

	public static void main(String[] args) {
		StaticMethClass ob = new StaticMethClass();
 		new ThreadA("A", ob);
		new ThreadB("B", ob);


	}

}


class ThreadA implements Runnable{
	
	String threadName;
	StaticMethClass ob;
	
	public ThreadA(String threadName, StaticMethClass ob){
		this.threadName = threadName;
		this.ob = ob;
		
		new Thread(this, threadName ).start();
		
	}
	
	@Override
	public void run(){
		ob.meth1();
	}
}


class ThreadB implements Runnable{
	
	String threadName;
	StaticMethClass ob;
	
	public ThreadB(String threadName, StaticMethClass ob){
		this.threadName = threadName;
		this.ob = ob;
		
		new Thread(this, threadName ).start();
		
	}
	
	@Override
	public void run(){
		ob.meth2();
	}
}


class StaticMethClass {
	
	public  void meth1(){
		
		synchronized (this) {
			System.out.println("Entering Meth1");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Exiting Meth1");	
		}
		

		
	} 
	
	public   void meth2(){
		synchronized (this) {
			System.out.println("Entering Meth2");

			System.out.println("Exiting Meth2");
		}

	} 
}