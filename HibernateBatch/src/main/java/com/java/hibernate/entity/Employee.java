package com.java.hibernate.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Employee {
   
   @Id
   @TableGenerator(name = "EMP_SEQ")
   @GeneratedValue(strategy = GenerationType.TABLE, generator = "EMP_SEQ")
   private Long id;
   
   private String name;
   private String email;
   
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
 
  //Getter and Setter methods
}