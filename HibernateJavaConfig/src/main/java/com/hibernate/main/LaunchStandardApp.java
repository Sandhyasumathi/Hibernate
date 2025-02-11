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

		config = new Configuration().addAnnotatedClass(Student.class);
		
        config.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
        config.setProperty("hibernate.connection.url","jdbc:mysql://localHost:3306/hibernate");
        config.setProperty("hibernate.connection.password","root");
        config.setProperty("hibernate.connection.username","root");
        config.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.hbm2ddl.auto","update");
        config.setProperty("hibernate.show_sql","true");
        config.setProperty("hibernate.format_sql","true");
		sf = config.buildSessionFactory();
		session = sf.openSession();

		Student s = new Student();
		s.setId(3);
		s.setName("Name3");
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
