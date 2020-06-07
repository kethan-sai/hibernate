package net.java.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.java.hibernate.entity.Student;
import net.java.hibernate.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		Student student = new Student("Jack","Reacher");
		Student student1 = new Student("padre", "ramoz");
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(student);
			session.save(student1);
			
			transaction.commit();
		}
		catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			List<Student> students = session.createQuery("from Student", Student.class).list();
			students.forEach(s -> System.out.println(s.getId()+" "+s.getFirstName()+" " + s.getLastName()));
		}
		catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

}
