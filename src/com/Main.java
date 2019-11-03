package com;

import java.util.*;

import javax.persistence.EntityManager;

import model.Course;
import model.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em =  HibernateOGMUtil.getEntityManagerFactory().createEntityManager();
		Set<Course> courses = new HashSet<Course>();
		courses.add(new Course("Maths"));
		courses.add(new Course("Computer Science"));

		Student student1 = new Student("Eswar", courses);
		Student student2 = new Student("Joe", courses);
		
		em.getTransaction().begin();
		
		em.persist(student1);
		em.persist(student2);
		
		em.getTransaction().commit();
		
		System.out.println("done...");

	}

}
