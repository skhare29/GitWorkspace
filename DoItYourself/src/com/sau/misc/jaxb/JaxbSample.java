package com.sau.misc.jaxb;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

public class JaxbSample {
	private static Unmarshaller um = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		String sCurrentLine = null;
		StringBuffer str = new StringBuffer("");
		Employee emp = null;
		JAXBContext context = null;

		try {
			context = JAXBContext.newInstance("com.sau.misc.jaxb");

			um = context.createUnmarshaller();

			br = new BufferedReader(new FileReader(".\\com\\sau\\misc\\jaxb\\conf\\employee.xml"));

			while ((sCurrentLine = br.readLine()) != null) {
				// System.out.println(sCurrentLine);
				str.append(sCurrentLine + "\n");
			}
			sCurrentLine = str.toString();
			System.out.println(sCurrentLine);

			InputStream in = new ByteArrayInputStream(sCurrentLine.getBytes());
			Object ob = um.unmarshal(in);
			emp = (Employee) ((JAXBElement)ob).getValue();

			System.out.println(">> " + emp.getSalary());

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
;