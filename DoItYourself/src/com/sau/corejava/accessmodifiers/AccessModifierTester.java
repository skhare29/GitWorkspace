package com.sau.corejava.accessmodifiers;

import com.sau.corejava.accessmodifiers.differentpackage.AnotherSuperClass;
import com.sau.corejava.accessmodifiers.differentpackage.SubClassB;
import com.sau.corejava.accessmodifiers.differentpackage.SubClassD;

public class AccessModifierTester {

	public static void main(String[] args){
		SuperClass superClass = new SuperClass();
		SubClassA subClassA = new SubClassA();
		SubClassB subClassB = new SubClassB();
		AnotherSuperClass anotherSuperClass = new AnotherSuperClass();
		SubClassC subClassC = new SubClassC();
		SubClassD subClassD = new SubClassD();
		

//		System.out.println("Same Package >> " + superClass.);
//		System.out.println("Same Package >> " + subClassA.);
//		System.out.println("Different Package (Extending Superclass which is in same package)>> " + subClassB.);
//		System.out.println("Different Package >> " + anotherSuperClass.);
//		System.out.println("Same Package (Extending Superclass which is in different package)>> " + subClassC.);
//		System.out.println("Different Package (Extending Superclass which is in same package)>> " + subClassD.);

	
	}
}
