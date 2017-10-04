package com.sau.corejava.thread.executer.scheduleThreadPoolExecuter;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

		// schedule to run after sometime
		System.out.println("Current Time = " + new Date());
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			WorkerThread worker = new WorkerThread("do heavy processing");

			// This will schedule the worker thread to execute after 10sec delay
			/*
			 * Creates and executes a one-shot action that becomes enabled after
			 * the given delay.
			 */
			
			scheduledThreadPool.schedule(worker, 10, TimeUnit.SECONDS);

			// schedule task to execute at fixed rate
			/*
			 * Creates and executes a periodic action that becomes enabled first
			 * after the given initial delay, and subsequently with the given
			 * period; that is executions will commence after initialDelay then
			 * initialDelay+period, then initialDelay + 2 * period, and so on.
			 */
			
			scheduledThreadPool.scheduleAtFixedRate(worker, 0, 10, TimeUnit.SECONDS);

			// schedule task to execute at fixed Delay
			/*
			 * Creates and executes a periodic action that becomes enabled first
			 * after the given initial delay, and subsequently with the given
			 * delay between the termination of one execution and the
			 * commencement of the next.
			 */
			
			scheduledThreadPool.scheduleWithFixedDelay(worker, 0, 1, TimeUnit.SECONDS);
		}

		// add some delay to let some threads spawn by scheduler
		Thread.sleep(30000);

		scheduledThreadPool.shutdown();
		while (!scheduledThreadPool.isTerminated()) {
			// wait for all tasks to finish
		}
		System.out.println("Finished all threads");
	}

}

class WorkerThread implements Runnable {

	private String command;

	public WorkerThread(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
	}

	private void processCommand() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.command;
	}
}
