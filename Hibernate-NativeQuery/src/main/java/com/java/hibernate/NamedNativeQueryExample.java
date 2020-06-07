package com.java.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.hibernate.entity.Department;
import com.java.hibernate.entity.Employee;

public class NamedNativeQueryExample {
	   @SuppressWarnings("unchecked")
	   public static void main(String[] args) {
	      Session session = null;
	      Transaction transaction = null;
	      try {
	         session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
	         
	         // Executing named native queries 
	         
	         List<Object> totalEmp=session.createNamedQuery("get_total_emp").getResultList();
	         System.out.println("Total Employees : "+totalEmp.get(0));
	         
	         List<Object> totalEmpByDept=session.createNamedQuery("get_total_emp_by_dept")
	               .setParameter("did", 2)
	               .getResultList();
	         System.out.println("Total Employees : "+totalEmpByDept.get(0));
	         
	         List<Employee> employees=session.createNamedQuery("get_all_emp",Employee.class)
	               .getResultList();
	         for (Employee employee : employees) {
	            System.out.println("EMP ID : "+employee.getId()+"\t NAME : "+employee.getName()+"\tDESIGNATION : "+employee.getDesignation());
	            Department department=employee.getDepartment();
	            System.out.println("\t Department : "+department.getName());
	         }
	         transaction.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         if (session != null) {
	            session.close();
	         }
	      }
	      HibernateUtil.shutdown();
	   }
	}