package com.sau.corejava.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private final BlockingQueue<Runnable> workerQueue;
	private final Thread[] workerThreads;

	public ThreadPool(int numThreads) {
		workerQueue = new LinkedBlockingQueue<Runnable>();
		workerThreads = new Thread[numThreads];

		int i = 0;
		for (Thread t : workerThreads) {
			i++;
			t = new Worker("Pool Thread "+i);
			t.start();
		}
	}
	
	public void addTask(Runnable r){
		try {
			workerQueue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private class Worker extends Thread {
		
		public Worker(String name){
			super(name);
			ThreadCount.updateCount();
		}
		
		public void run() {
			System.out.println("Inside run of worker thread " + this.getName());
			while (true) {
				try {
					Runnable r = workerQueue.take();
					//System.out.println("Before Execution - Worker Thtead " + this.getName());
					System.out.println("Worker Thread " + this.getName() + " catering thread " + (r instanceof ProducerConsumerModified.Consumer ? ((ProducerConsumerModified.Consumer)r).name : ((ProducerConsumerModified.Producer)r).name ));
					r.run();
					//System.out.println("After Execution - Worker Thtead " + this.getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
		}
	}

}