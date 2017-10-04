package com.sau.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Interceptor;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sau.hibernate.entities.UserDetail;
import com.sau.hibernate.util.HibernateUtil;

public class Main {


	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		
		UserDetail userDetail = new UserDetail();
		userDetail.setId(1);
		userDetail.setName("Saurabh Khare");
		
		session.save(userDetail);
	
		tran.commit();
		session.close();

		
		
	}
	
	public void JustTesting(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria cr =  session.createCriteria("UserDetail");
		//Restrictions
		
		Query q = session.createQuery("");
		//q.set
		
		SQLQuery sq = session.createSQLQuery("");
		//sq.
		
		
	}

}
