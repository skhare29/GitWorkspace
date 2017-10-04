package com.sau.corejava.serialization.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.sau.corejava.serialization.serializable.someclasses.Manager;

public class SerializationDemo {

	public static void main(String[] args) {
		System.out.println("In main method");

		SerializationDemo main = new SerializationDemo();

		SingletonClass sin = SingletonClass.getInstance();

		SingletonClass sin2 = main.getDeepClone(sin);

		System.out.println(sin + "  " + sin2);

		// Department dept = new Department();
		// Department clonedDept = main.getDeepClone(dept);
		//
		// testEquality(dept, clonedDept);

		Manager man = new Manager();
		Manager clonedMan = main.getDeepClone(man);

		testEquality(man, clonedMan);
	}

	static private void testEquality(Object original, Object cloned) {
		if (original.equals(cloned)) {
			System.out.println("True");
		} else {
			System.out.println("false");
		}

		if (original == cloned) {
			System.out.println("True");
		} else {
			System.out.println("false");
		}

		System.err.println(original);
		System.out.println(cloned);
	}

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

class SingletonClass implements Serializable {

	public int i = 0;

	private SingletonClass() {

	}

	public static SingletonClass getInstance() {
		return new SingletonClass();
	}
}

