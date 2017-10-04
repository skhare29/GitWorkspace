package com.sau.classesToPlayWith;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable{
	
	String name = "Admin";
	int id = 123;
	List list = new ArrayList();
	
	public Department(){
		list.add(new Employee());
	}
	
	//Employee emp = new Employee();
	
	public String toString(){
		
		return "Name: " + name + ", Id: " + id;
	}

	public boolean equals(Object ob){
 
		
		if(this.name.equals(((Department)ob).name) && this.id== ((Department)ob).id && this.list.containsAll(((Department)ob).list)){
			return true;
		}else{
			return false;
		}
		
		 
	}
	
}
