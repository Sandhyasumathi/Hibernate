package com.hibernate.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.model.StudentsTable;


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

//		StudentsTable s = new StudentsTable();
//		s.setId(0);
//		s.setName("Name0");
//		
//		StudentsTable s1 = new StudentsTable();
//		s1.setId(1);
//		s1.setName("Name1");
//		
//		CourseTable c = new CourseTable();
//		c.setCid(0);
//		c.setCname("Course0");
//		
//		CourseTable c1 = new CourseTable();
//		c1.setCid(1);
//		c1.setCname("Course1");
//		
//		List<CourseTable> cList = new ArrayList<>();
//		cList.add(c);
//		cList.add(c1);
//		
//		List<StudentsTable> sList = new ArrayList<>();
//		sList.add(s);
//		sList.add(s1);
//		
//		s.setCourseList(cList);
//		s1.setCourseList(cList);
//		
//		c.setStudentList(sList);
//		c1.setStudentList(sList);
		
//		StudentsTable students = session.get(StudentsTable.class, 0);
//		System.out.println(students.getName());
//		for(CourseTable c : students.getCourseList()) {
//			System.out.println(c);
//		}
		
		 Query<StudentsTable> query = session.createQuery("From StudentsTable",StudentsTable.class);
		 List<StudentsTable> sList = query.list();
		 
		 for(StudentsTable s :sList) {
			 System.out.println(s);
		 }

		try {
			t = session.beginTransaction();
//			session.persist(s);
//			session.persist(s1);
			
//			flag=true;
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
