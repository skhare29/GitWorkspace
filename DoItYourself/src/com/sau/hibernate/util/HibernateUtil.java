package com.sau.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static final String hibernateConfigStr = "com/sau/hibernate/config/hibernate.cfg.xml";	
	
	public static SessionFactory getSessionFactory(){
		return new Configuration().configure(hibernateConfigStr).buildSessionFactory();
	}
	
}
