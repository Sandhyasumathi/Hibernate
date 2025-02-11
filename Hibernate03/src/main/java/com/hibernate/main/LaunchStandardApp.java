package com.hibernate.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Student;

public class LaunchStandardApp {

	public static void main(String[] args) {

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf = null;
		Session session = null;
		Session session2 = null;
		Transaction t=null;
		boolean flag=false;

		sf = config.buildSessionFactory();
		session = sf.openSession();
		session2 = sf.openSession();
		

//		Student s = new Student();
//		s.setId(0);
//		s.setName("Name0");
//		s.setCity("City0");
		
		try {
//			t = session.beginTransaction();
			//session.merge(s);
			//session.remove(s);
			//session.merge(s);
			Student s = session.getReference(Student.class, 1);
			System.out.println(s);
			
			Student s2 = session.getReference(Student.class, 1);
			System.out.println(s2);
			
			
			Student s3 = session2.getReference(Student.class, 1);
            System.out.println(s3);
			flag=true;
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
//			if(flag) {
//				t.commit();
//			}else {
//				t.rollback();
//			}
			
			session.close();
			sf.close();
		}
	}

}
