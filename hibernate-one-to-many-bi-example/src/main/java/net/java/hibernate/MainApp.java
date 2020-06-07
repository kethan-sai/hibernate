package net.java.hibernate;

import net.java.hibernate.dao.AuthorDao;
import net.java.hibernate.dao.DepartmentDao;
import net.java.hibernate.entity.Author;
import net.java.hibernate.entity.Department;

public class MainApp {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = new DepartmentDao();
		AuthorDao authorDao = new AuthorDao();
		
		Department department = new Department("Contemporary");
		departmentDao.saveDepartment(department);
		
		Author author = new Author("Maxwell");
		author.setDepartment(department);
		authorDao.saveCourse(author);
		
		
		Author author1 = new Author("Martha");
		author.setDepartment(department);
		authorDao.saveCourse(author1);
		System.out.println(author.toString());
		System.out.println(author1.toString());
		

		
		Department department1 = new Department("Classics");
		departmentDao.saveDepartment(department1);
		
		Author author2 = new Author("Morty");
		author.setDepartment(department1);
		authorDao.saveCourse(author2);
		
		
		Author author3 = new Author("Mellinda");
		author.setDepartment(department1);
		authorDao.saveCourse(author3);

		System.out.println(author2.toString());
		System.out.println(author3.toString());
	}

}
