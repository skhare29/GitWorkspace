package com.sau.corejava.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectFileWriter {

	public static void main(String[] args) {

		writeToFile();
		//readFromFile();
	}
	
	private static void readFromFile(){
		try (FileInputStream fis = new FileInputStream("ObjectStateHolder.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			Vehicle vehicle;
			
			vehicle = (Vehicle)ois.readObject();
			
			System.out.println(vehicle);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("Finally called");
		}
	}
	
	private static void writeToFile(){
		try (FileOutputStream fos = new FileOutputStream("ObjectStateHolder.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			Vehicle vehicle = new Vehicle("Car", 4);
			
			oos.writeObject(vehicle);
			oos.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("Finally called");
		}
	}

}

class Vehicle implements Serializable{
	
	private String type;
	private int wheels ;
	
	
	public Vehicle(String type, int wheels){
		this.type = type;
		this.wheels = wheels;
	}
	
	public String toString(){
		return "Type: " +type + ", Wheels: " + wheels;
	}
	
}

