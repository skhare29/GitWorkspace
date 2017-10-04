package com.sau.corejava.thread.synchronizer.Exchanger;

import java.util.concurrent.Exchanger;

/*
In the program, the main( ) method creates an Exchanger for strings. This object is
then used to synchronize the exchange of strings between the MakeString and UseString
classes. The MakeString class fills a string with data. The UseString exchanges an empty
string for a full one. It then displays the contents of the newly constructed string. The
exchange of empty and full buffers is synchronized by the exchange( ) method, which is
called by both classes’ run( ) method.
*/

class ExchangerDemo {
	public static void main(String args[]) {
		Exchanger<String> exgr = new Exchanger<String>();
		new UseString(exgr, "Use");
		new MakeString(exgr, "Make");
	}
}

// A Thread that constructs a string.
class MakeString implements Runnable {
	Exchanger<String> ex;
	String str;


	MakeString(Exchanger<String> c, String name) {
		ex = c;
		str = new String();
		new Thread(this, name).start();
	}

	public void run() {
		char ch = 'A';
		for (int i = 0; i < 3; i++) {
			// Fill Buffer
			for (int j = 0; j < 5; j++)
				str += ch++;
			try {
				System.out.println("Before Exchange. In Thread " + Thread.currentThread().getName());
				// Exchange a full buffer for an empty one.
				str = ex.exchange(str);
				System.out.println("After Exchange. In Thread " + Thread.currentThread().getName());
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}
}

// A Thread that uses a string.
class UseString implements Runnable {
	Exchanger<String> ex;
	String str;

	UseString(Exchanger<String> c, String name) {
		ex = c;
		new Thread(this,name).start();
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				System.out.println("Before Exchange. In Thread " + Thread.currentThread().getName());
				Thread.sleep(100);
				// Exchange an empty buffer for a full one.
				str = ex.exchange(new String());
				System.out.println("After Exchange. In Thread " + Thread.currentThread().getName());
				System.out.println("Got: " + str);

			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}
}