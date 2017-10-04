package com.sau.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sau.someclasses.Department;

public class Main {

	public static void main(String[] args) {
		System.out.println("In main method");

		StaticInitialization ob1 = new StaticInitialization();
		
		AB ob = new AB();
		
		C c = new A();
		
		
		
		System.out.println(ob.meth());
		
		Main main = new Main();

		Department dept = new Department();
		Department clonedDept = main.getDeepClone(dept);

		if (dept.equals(clonedDept)) {
			System.out.println("True");
		} else {
			System.out.println("false");
		}

		if (dept == clonedDept) {
			System.out.println("True");
		} else {
			System.out.println("false");
		}

		System.err.println(dept);
		System.out.println(clonedDept);

	}

	// @SuppressWarnings("unchecked")
	// public <T> T getDeepClone(T classObject) {
	// T clonedObject = null;
	//
	// ByteArrayInputStream bais;
	// ObjectInputStream ois;
	//
	// try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
	// ObjectOutputStream oos = new ObjectOutputStream(baos);) {
	//
	// oos.writeObject(classObject);
	//
	// bais = new ByteArrayInputStream(baos.toByteArray());
	// ois = new ObjectInputStream(bais);
	// clonedObject = (T) ois.readObject();
	//
	// bais.close();
	// ois.close();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return clonedObject;
	// }

	@SuppressWarnings("unchecked")
	public <T> T getDeepClone(T orgObject) {
		T clonedObject = null;

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(orgObject);

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			clonedObject = (T) ois.readObject();

			oos.close();
			baos.close();
			bais.close();
			ois.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return clonedObject;
	}

}
