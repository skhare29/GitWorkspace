package com.sau.corejava.accessmodifiers;

import com.sau.corejava.accessmodifiers.differentpackage.AnotherSuperClass;

public class SubClassC extends AnotherSuperClass {
	
	public void meth() {
		System.out.println("this.");
	}
	
	void methdefault(){
		
	}


	protected void methProtected(){
		
	}
	
	@Override
	public void methPublic(){
		
	}
	
	
}
