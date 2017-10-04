package com.sau.corejava.collections;

//Read more: http://www.java67.com/2015/07/how-to-use-priorityqueue-in-java-example.html#ixzz4bxjMhiEs

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * * Simple Java Program to demonstrate how to use PriorityQueue * in Java.
 * PriorityQueue is used to process elements as * per their priority defined by
 * Comparator or Comparable. 
 */

public class PriorityQueueDemo {
	public static void main(String[] args) {
		// creating an instance of PriorityQueue in Java
		// Its better to define initial capacity because
		// its backed by array
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(16);
		
		// adding numbers into PriorityQueue in arbitrary order
		pq.add(3); //alternate offer()
		pq.add(7);
		pq.add(2);
		pq.add(4);
		pq.add(1);
		pq.add(5);
		
		
		
		// Now, let's if PriorityQueue keeps the smallest
		// element in head or not. Let's use peek method
		// to check that, peek() returns the head of the
		// queue
		Integer head = pq.peek();//alternate element()
		System.out.println("size of PriorityQueue : " + pq.size());
		System.out.println("head of the PriorityQueue : " + head);
		
		// Now, let's remove the head and see what comes
		// next, you can use poll() method to remove
		// element from head
		head = pq.poll();//alternate remove()
		head = pq.peek();
		System.out.println("Current value of head : " + head);
		System.out.println("size of PriorityQueue : " + pq.size());
		
		// Iterating over PriorityQueue, iterator returned
		// by PriorityQueue doesn't guarantee any order
		Iterator<Integer> itr = pq.iterator();
		System.out.println("Iterating over PriorityQueue");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
