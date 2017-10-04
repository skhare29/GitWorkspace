package com.sau.corejava.reflection;

import java.lang.reflect.*;

public class ReflectionDemo {
	public static void main(String args[]) {
		try {
			A a = new A();
			//Class<?> c = a.getClass();
			Class<B> c = B.class;
			
			Constructor<B> con = c.getDeclaredConstructor(new Class[0]);
			con.setAccessible(true);
			
			B b = (B) con.newInstance();
			System.out.println(b.a);
			System.out.println("Public Methods:");
			Method methods[] = c.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				int modifiers = methods[i].getModifiers();
				if (Modifier.isPublic(modifiers)) {
					System.out.println(" " + methods[i].getName());
				}
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}

class A {
	public void a1() {
	}

	public void a2() {
	}

	protected void a3() {
	}

	private void a4() {
	}
}

class B{
	
	public int a = 1;
	
	private B(){
		
	}
}
