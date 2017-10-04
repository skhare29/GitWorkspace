package com.sau;

import java.awt.peer.SystemTrayPeer;
import java.io.IOException;
import java.util.Scanner;



 class Room<T> {
	 
	private T t;
 
	public void add(T t) {
		this.t = t;
	}
 
	public T get() {
		return t;
	}
}
 
public class SandBox {
	public static void main(String[] args) throws IOException {
		byte[] b = null; 
		Room<String> room = new Room<String>();
		room.add("60");
 
		String i = room.get();
		System.out.println(i);
		Scanner scanner = new Scanner(System.in);
		System.out.println(scanner.nextLine());
		
	}
}