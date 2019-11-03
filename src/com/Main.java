package com;

import java.util.*;

import javax.persistence.EntityManager;

import model.Course;
import model.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em =  HibernateOGMUtil.getEntityManagerFactory().createEntityManager();
		Set<Course> courses = new HashSet<>();
		Set<Student> students = new HashSet<>(0);
		
		Course c1 = new Course("maths");
		Course c2 = new Course("English");
		
		Student s1 = new Student("Carl");
		Student s2 = new Student("Joseph");
		
		courses.add(c1);
		courses.add(c2);
		
		students.add(s1);
		students.add(s2);
		
		c1.setStudents(students);
		c2.setStudents(students);
		
		s1.setCourses(courses);
		s2.setCourses(courses);
		
		
		em.getTransaction().begin();
		
		em.persist(s1);
		em.persist(s2);
		
		em.getTransaction().commit();
		
		System.out.println("done...");

	}

}
