package com.sau.corejava.fibonacci;

import java.awt.geom.GeneralPath;

public class Fibonacci {

	public static void main(String[] args) {
		//System.out.println(generateFibonacci(0, 1, 10));
		System.out.println(fibonacciLoop(10));
	}

	//MyLogic
	public static int generateFibonacci(int num1, int num2, int uptoNum) {
		int temp = num1 + num2;

		if (--uptoNum == 0) {
			return num2;
		} else {
			System.out.println(num1 + " + " + num2 + " = " + temp);
			return generateFibonacci(num2, temp, uptoNum);
		}

	}
	
	// Method-1: Java program for Fibonacci number using recursion.
	public static int fibonacciRecusion(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
 
		return fibonacciRecusion(number - 1) + fibonacciRecusion(number - 2); // tail recursion
	}
 
	// Method-2: Java program for Fibonacci number using Loop.
	public static int fibonacciLoop(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		int fibo1 = 1, fibo2 = 1, fibonacci = 1;
		for (int i = 3; i <= number; i++) {
			fibonacci = fibo1 + fibo2; // Fibonacci number is sum of previous two Fibonacci number
			fibo1 = fibo2;
			fibo2 = fibonacci;
 
		}
		return fibonacci; // Fibonacci number
	}

}
