package com.sau;

import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GeneralTesting {

	public void xxx(String... rgs) {

	}

	public static void main(String[] args) {
		xx.meth();
		
	
		new xx();

		Set map = new HashSet();
		
		map.add(null);
		
		System.out.println(map.contains(null));
		
		try {
			//System.in.read();
			//Runtime.getRuntime().
			

			
			System.out.println(x.str);
			x.interfaceMeth1();
			//throw new IOException();
			//return;
			System.exit(1);
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			System.out.println("Inside Finally");
		}

	}
}

 class xx {
	 
	 static {
		 System.out.println("Inside static block");
		 //int i = 1/0;
	 }
	 
	 {
		 System.out.println("Inside instance block");
	 }
	 
	static void meth() {
		System.out.println("print");
	}
}

interface x {

	String str = "X";
	
	  public static void interfaceMeth1(){
		System.err.println("Inside interface method1");
	}
	 
	  public default void interfaceMeth2() {
		System.err.println("Inside interface method2");
	}


}