package com.sau.main;

public class StaticInitialization {
	
	int a = 0;
	
	public static void main(String[] args){
		final StringBuffer strb = new StringBuffer("test");
		
		strb.append("Mod"); 
		
		System.out.println("In Main " + strb);
	}
	
	static {

			System.out.println("In Static block");
			InnerClass.meth();

	}

	static class InnerClass{
		static void meth() {
			System.out.println("In Meth");
			//throw new Exception("From meth()");
			
		}
	}

}
