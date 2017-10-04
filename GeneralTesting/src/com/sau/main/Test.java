package com.sau.main;

import java.util.Comparator;

public class Test {
	int abc = 1;
	
	private static void doStuff(String str) {

	}

	public static void main(String args[]) {

		// A local variable that can be captured.
		int num = 10;
		Test t = new Test();
		
		MyFunc1 myLambda = (n) -> {
			// This use of num is OK. It does not modify num.
			int v = num + n ;
			// However, the following is illegal because it attempts
			// to modify the value of num.
			// num++;

			return v;
		};
		// The following line would also cause an error, because
		// it would remove the effectively final status from num.
		// num = 9;
		
		System.out.println(myLambda.func(5));
		
	}

}

class AnyObject implements Comparable {
	public String a;
	public Integer b;

	public AnyObject(String a, Integer b) {
		this.a = a;
		this.b = b;
	}

	public String toString() {
		return a + ", " + b;
	}

	@Override
	public int compareTo(Object arg0) {

		return this.b.compareTo(((AnyObject) arg0).b) * -1;
	}
}

class AnyObjectComparator implements Comparator<AnyObject> {

	@Override
	public int compare(AnyObject arg1, AnyObject arg2) {

		return arg1.b.compareTo(((AnyObject) arg2).b);
	}

}

interface MyFunc1 {
	int func(int n);
}