package com.hibernate.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Student;

public class LaunchStandardApp {

	public static void main(String[] args) {

		Configuration config = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction t=null;
		boolean flag=false;

		config = new Configuration();
		config.configure();
		sf = config.buildSessionFactory();
		session = sf.openSession();

		Student s = new Student();
		//s.setId(1);
		s.setName("Name2");
		s.setCity("City3");
		
		try {
			t = session.beginTransaction();
			session.persist(s);
			flag=true;
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if(flag) {
				t.commit();
			}else {
				t.rollback();
			}
			
			session.close();
			sf.close();
		}
	}

}
