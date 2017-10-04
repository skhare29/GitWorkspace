package com.sau.corejava.thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerModified {

	private final BlockingQueue<Integer> queue;
	private static final Random rnd = new Random();

	public static void main(String[] args) {
		ProducerConsumerModified prodconsumer = new ProducerConsumerModified();
		prodconsumer.init();
		System.out.println("Exiting. Thread count is " + ThreadCount.getCount());
	}

	public ProducerConsumerModified() {
		queue = new LinkedBlockingQueue(2);
	}

	private void init() {
		ThreadPool pool = new ThreadPool(2);
		for(int i = 0; i < 3; i++){
			pool.addTask(new Producer("Pro A " + i ));
			pool.addTask(new Producer("Pro B " + i ));
			pool.addTask(new Producer("Pro C " + i ));
			
			pool.addTask(new Consumer("Con X " + i ));
			pool.addTask(new Consumer("Con Y " + i ));
			pool.addTask(new Consumer("Con Z " + i ));
		}
		
	}

	public class Producer implements Runnable {
		public String name;
		
		public Producer(String name){
			this.name = name;
			ThreadCount.updateCount();
		}

		public void run() {
			
			Integer e = rnd.nextInt(100);
			//System.out.println("Inserting Element "  + name + " " + e);
			System.out.println("Inserting Element "  + name);
			try {
				queue.put(e);
				
				Thread.sleep(1000);
			} catch (InterruptedException e2) {

				e2.printStackTrace();
			}

		}
	}

	public class Consumer implements Runnable {

		public String name;
		
		public Consumer(String name){
			this.name = name;
			ThreadCount.updateCount();
		}
		
		public void run() {
				try {
					//System.out.println("Removing Element " + name + " - " + queue.take());
					System.out.println("Removing Element " + name);
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

	}

}
