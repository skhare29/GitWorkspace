package com.sau.corejava.thread.interrupt;


/*
If thread is not in sleeping or waiting state, 
calling the interrupt() method sets the interrupted flag to true 
that can be used to stop the thread by the java programmer later.
*/

class TestInterruptingThread3 extends Thread {

	public void run() {
		for (int i = 1; i <= 3; i++){
			
			Runnable threadOb = new Runnable() {
				
				@Override
				public void run() {
					System.out.println("Running Thread " + Thread.currentThread().getName());
					DummyClass d;
					while(true){
					
							//Thread.sleep(100);
							
							 d = new DummyClass();
							 
							 d.num = 10;
							
							
							
//						
						
					}
				}
			};
			
			new Thread(threadOb, "Thread " + i).start();
			
		}
	}

	public static void main(String args[]) {
		
		System.out.println(Thread.currentThread().getName());
		
		TestInterruptingThread3 t1 = new TestInterruptingThread3();
		t1.start();

		t1.interrupt();

	}
	
	class DummyClass{
		int num = 0;
	}
}
