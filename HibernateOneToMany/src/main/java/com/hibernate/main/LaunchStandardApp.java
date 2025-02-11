package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Answer;
import com.hibernate.model.Question;

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

//	    Question q1 = new Question();
//	    q1.setId(0);
//	    q1.setQuestion("Question1");
//	    
//	    Answer a1 = new Answer();
//	    a1.setId(0);
//	    a1.setQuestion(q1);
//	    a1.setAnswer("Answer1");
//	    
//	    Answer a2 = new Answer();
//	    a2.setId(1);
//	    a2.setQuestion(q1);
//	    a2.setAnswer("Answer2");
//	    
//	    List<Answer> answers = new ArrayList<>();
//	    answers.add(a1);
//	    answers.add(a2);
//	    
//	    q1.setAnswer(answers);
		
	   Question question = session.get(Question.class, 0);
	   System.out.println(question.getId());
	   System.out.println(question.getQuestion());
	   System.out.println(question.getAnswer());
	   for(Answer a : question.getAnswer()) {
		   System.out.println(a.getAnswer());
	   }
		
		try {
			t = session.beginTransaction();
//			session.persist(q1);
			
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
