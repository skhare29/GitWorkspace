package com.sau.corejava.general;

public class NestedAndInnerClasses {

	public static void main(String[] args){
		OuterClass outerClass = new OuterClass();
		OuterClass.NestedClass outerClassNestedClass = new OuterClass.NestedClass();
		OuterClass.InnerClass outerClassInnerClass = new OuterClass().new InnerClass();
		
		outerClass.localInnerClassMeth();
		outerClass.localAnonymousInnerClassMeth();
		
		outerClassNestedClass.display();
		outerClassInnerClass.display();
		
	}
	
}


// Four Types of Nested/Inner classes
class OuterClass {
	static int staticVar = 1;
	int nonStaticVar = 2;

	static void staticOuterClassMeth() {
		System.out.println("Static Outer Class Method");
	}

	void nonStaticOuterClassMeth() {
		System.out.println("Non Static Outer Class Method");
	}

	// TYPE 1 -  Static Nested class Outer class
	static class NestedClass {

		void display() {
			System.out.println(staticVar); // Accessible
			// System.out.println(nonStaticVar); Not Accessible

			staticOuterClassMeth();
			// nonStaticOuterClassMeth(); Not Accessible

		}

	}

	// TYPE 2 - Non-Static Nested class (called as INNER CLASS) within Outer class.
	class InnerClass {

		void display() {
			System.out.println(staticVar); // Accessible
			System.out.println(nonStaticVar); // Accessible

			staticOuterClassMeth();
			nonStaticOuterClassMeth();
		}
	}

	void localInnerClassMeth() {
		final int var = 5; 	//Has to be made final. REASON - Local variables of a method are stored on STACK memory type. 
							//Their scope ends (thereby killing the local variable) as soon as method finishes. 
							//But the object of local inner/anonymous class that refer to this variable will still be alive as it is stored on HEAP memory type.    
							//By making this variable as final it will be treated as constant and will not be stored on Stack, hence will not cause any conflict. 

		// TYPE 3 - Inner class within a Outer class Method;
		class LocalInnerClass {

			int localInnerClassVar = 0;

			void meth() {
				System.out.println(var + " " + localInnerClassVar + " " +  staticVar + " " +  nonStaticVar);
			}
		}
		
		LocalInnerClass localInnerClass = new LocalInnerClass();
		localInnerClass.meth();
		

	}

	void localAnonymousInnerClassMeth() {
		final int var = 5; // Has to be made final. Reason is given above

		// TYPE 4 - Anonymous Class. Class with no name that subclasses and overrides the methods of super class at rumtime.
		OuterClass.InnerClass ob = new OuterClass().new InnerClass() {

			int localInnerClassVar = 0;

			void display() {
				System.out.println(staticVar); // Accessible
				System.out.println(nonStaticVar); // Accessible

				System.out.println(var + " " + localInnerClassVar + " " +  staticVar + " " +  nonStaticVar);

				staticOuterClassMeth();
				nonStaticOuterClassMeth();
			}
		};
		
		ob.display();

	}

}
