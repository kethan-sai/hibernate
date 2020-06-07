package net.java.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.java.hibernate.entity.Department;
import net.java.hibernate.util.HibernateUtil;

public class DepartmentDao {
	public void saveDepartment(Department department) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// start a transaction
			   transaction = session.beginTransaction();
			   // save the student object
			   session.save(department);
			   // commit transaction
			   transaction.commit();
		}
		catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	 public void updateInstructor(Department department) {
		  Transaction transaction = null;
		  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		   // start a transaction
		   transaction = session.beginTransaction();
		   // save the student object
		   session.update(department);
		   // commit transaction
		   transaction.commit();
		  } catch (Exception e) {
		   if (transaction != null) {
		    transaction.rollback();
		   }
		   e.printStackTrace();
		  }
		 }

		 public void deleteInstructor(int id) {

		  Transaction transaction = null;
		  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		   // start a transaction
		   transaction = session.beginTransaction();

		   // Delete a instructor object
		   Department department = session.get(Department.class, id);
		   if (department != null) {
		    session.delete(department);
		    System.out.println("instructor is deleted");
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

		 public Department getInstructor(int id) {

		  Transaction transaction = null;
		  Department department = null;
		  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		   // start a transaction
		   transaction = session.beginTransaction();
		   // get an instructor object
		   department = session.get(Department.class, id);
		   // commit transaction
		   transaction.commit();
		  } catch (Exception e) {
		   if (transaction != null) {
		    transaction.rollback();
		   }
		   e.printStackTrace();
		  }
		  return department;
		 }
}
