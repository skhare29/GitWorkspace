package com.sau.corejava.thread;

public class ThreadCount {
	
	static private int count = 0;
	
	static public void updateCount(){
		count++;
	}
	
	static public int getCount(){
		return count;
	}

}
