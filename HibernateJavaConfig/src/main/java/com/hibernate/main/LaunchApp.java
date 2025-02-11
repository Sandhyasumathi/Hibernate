package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Student;

public class LaunchApp {

	public static void main(String[] args) {

		// Step 01 - Create Configuration Object
		Configuration config = new Configuration();

		// Step 02 - Pass the configuration file by invoking configure
		config.configure();// need to pass if we specify any custom config file name not needed if the file
							// name is hibernate.cfg.xml
		
		//Step 03 - Creating object of Session factory
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		//Step 04 - Creating object of Session 
		 Session session = sessionFactory.openSession();
		 
		 //Step 05 - Create an object of transaction incase of Non select query
		 Transaction transaction = session.beginTransaction();
		 
		 //Step 06 - Create instance of the Entity class
		 Student student = new Student();
		 student.setId(0);
		 student.setName("Name1");
		 student.setCity("City1");
		 
		 //Step 07 - Create Object of Operation 
		 session.save(student);
		 
		//Step 08 - Commit values
		 transaction.commit();
		 
		 //Step 09 - Close the session
		 session.close();
	}

}
