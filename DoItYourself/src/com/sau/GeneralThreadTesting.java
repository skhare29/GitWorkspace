package com.sau;

public class GeneralThreadTesting {

	public static void main(String[] args) {
		new RunnableTask("A");
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		new RunnableTask("B");

	}

}

class RunnableTask implements Runnable{
	
	
	
	public RunnableTask(String name) {
		new Thread(this , name).start();
	}
	
	
	@Override
	public  synchronized void run(){
		System.out.println("Entered Meth: " + Thread.currentThread().getName());
		
		try {
			meth1();
			Thread.sleep(1000);
			meth2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Exited Meth: " + Thread.currentThread().getName());
	}
	
	public void meth1(){
		System.out.println("Inside Meth1");
	}
	
	public void meth2(){
		System.out.println("Inside Meth2");
	}
	
	
}
