package net.java.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.java.hibernate.entity.Author;
import net.java.hibernate.util.HibernateUtil;

public class AuthorDao {
	public void saveCourse(Author author) {
		  Transaction transaction = null;
		  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		   // start a transaction
		   transaction = session.beginTransaction();
		   // save the student object
		   session.save(author);
		   // commit transaction
		   transaction.commit();
		  } catch (Exception e) {
		   if (transaction != null) {
		    transaction.rollback();
		   }
		   e.printStackTrace();
		  }
		 }

		 public void updateCourse(Author author) {
		  Transaction transaction = null;
		  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		   // start a transaction
		   transaction = session.beginTransaction();
		   // save the student object
		   session.update(author);
		   // commit transaction
		   transaction.commit();
		  } catch (Exception e) {
		   if (transaction != null) {
		    transaction.rollback();
		   }
		   e.printStackTrace();
		  }
		 }

		 public void deleteCourse(int id) {

		  Transaction transaction = null;
		  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		   // start a transaction
		   transaction = session.beginTransaction();

		   // Delete a course object
		   Author author = session.get(Author.class, id);
		   if (author != null) {
		    session.delete(author);
		    System.out.println("course is deleted");
		   }

		   // commit transaction
		   transaction.commit();
		  } catch (Exception e) {
		   if (transaction != null) {
		    transaction.rollback();
		   }
		   e.printStackTrace();
		  }
		 }

		 public Author getCourse(int id) {

		  Transaction transaction = null;
		  Author course = null;
		  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		   // start a transaction
		   transaction = session.beginTransaction();
		   // get an course object
		   course = session.get(Author.class, id);
		   // commit transaction
		   transaction.commit();
		  } catch (Exception e) {
		   if (transaction != null) {
		    transaction.rollback();
		   }
		   e.printStackTrace();
		  }
		  return course;
		 }
}
