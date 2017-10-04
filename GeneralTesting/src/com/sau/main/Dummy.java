package com.sau.main;

import java.io.IOException;
import java.util.Collections;

class Dummy {
	public static void main(String args[]) throws IOException {
		// ArrayList<Book> listOfBooks = new ArrayList<>();
		// listOfBooks.add(new Book("Book1", "Auth1", 22));
		// listOfBooks.add(new Book("Book2", "Auth2", 26));
		// listOfBooks.add(new Book("Book3", "Auth3", 25));
		// listOfBooks.add(new Book("Book4", "Auth4", 20));
		// listOfBooks.add(new Book("Book5", "Auth5", 29));
		//
		// Stream<Book> st = listOfBooks.stream();
		//
		// st = st.filter((Book book) -> book.auth.age>25);
		// Object[] ob = st.toArray();
		// st.close();
		//
		// for (Object book2 : ob) {
		// System.out.println(((Book) book2).toString());
		// }

		//ABC abc = new ABC();
		//abc.startup();
		

		
		String str = "SAURABH";
		byte[] arr = str.getBytes();
		byte[] temp = new byte[arr.length];
		
		int len = arr.length - 1;
		
		for (int i = 0; i < arr.length ; i++ ) {
			temp[len--] = arr[i];
			
		}
		
		System.out.println(new String(temp));

	}

}

enum Days {
	Sunday, Monday, Tuseday;

	void Days() {

	}

}

abstract class MyDefaultExceptionHandler implements Thread.UncaughtExceptionHandler{


	
}
   
class Book {
	Author auth;
	String bookName;

	public Book(String bookName, String authName, int authAge) {
		this.auth = new Author(authName, authAge);
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return bookName + " " + auth.name + " " + auth.age;
	}
}

class Author {
	String name;
	int age;

	public Author(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class ABC extends Thread {
	private long counter;
	private boolean status;

	public void startup() {

	
				(new ABC() {

			public void run() {
				while (!status) {
					System.out.println("Inside T1 :: Counter value is " + counter);
					counter++;
				}

			}
		}).start();

		Thread t2 = new ABC() {

			public void run() {

				while (true) {

					System.out.println("Inside T2");
					if (counter == 42) {
						System.out.println("Inside T2 and value is 42");
						status = true;
						break;
					}
				}
			}
		};

		//t1.start();
		t2.start();

	}
}
