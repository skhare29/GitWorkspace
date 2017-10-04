package com.sau.corejava.thread.interrupt;

/*
The isInterrupted() method returns the interrupted flag either true or false. 
The static interrupted() method returns the interrupted flag after 
that it sets the flag to false if it is true.
*/

public class TestInterruptingThread4 extends Thread {

	public TestInterruptingThread4(String name) {
		super(name);
	}

	public void run() {
		try {
			for (int i = 1; i <= 2; i++) {
				boolean flag = this.isInterrupted();
				System.out.println(this.getName() + " " + flag);
				if (flag) {
					System.out.println(this.getName() + " code for interrupted thread");
					return;
				} else {
					System.out.println(this.getName() + " code for normal thread");
				}


			} // end of for loop
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		TestInterruptingThread4 t1 = new TestInterruptingThread4("A");
		TestInterruptingThread4 t2 = new TestInterruptingThread4("B");

		t1.start();
		t1.interrupt();

		t2.start();

	}
}
