package com.sau.corejava.serialization.serializable.someclasses;

public class Employee  {
	
	public Employee(String name){}
	
	public Employee(){}

	String name = "ABC";

	@Override
	public String toString(){
		
		return "Name: " + name;
	}
	
	public boolean equals(Object ob){
		if(this.name.equals( ((Employee)ob).name)){
			return true;
		} else{
			return false;
		}
	}
	
}
