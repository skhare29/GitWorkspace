package com.sau.someclasses;

import java.io.Serializable;

public class Employee implements Serializable {

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
