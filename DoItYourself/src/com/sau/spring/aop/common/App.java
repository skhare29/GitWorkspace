package com.sau.spring.aop.common;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sau.spring.aop.customer.services.CustomerService;
 
public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "com\\sau\\spring\\aop\\conf\\Spring-Customer.xml" });
 
		CustomerService cust = 
                                (CustomerService) appContext.getBean("customerServiceProxy");
 
		System.out.println("*************************");
		cust.printName();
		System.out.println("*************************");
		cust.printURL();
		System.out.println("*************************");
		try {
			cust.printThrowException();
		} catch (Exception e) {
 
		}
 
	}
}