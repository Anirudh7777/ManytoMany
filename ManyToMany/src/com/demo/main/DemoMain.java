package com.demo.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.demo.entity.Course;
import com.demo.entity.Student;

public class DemoMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("ManyToMany");
		EntityManager em = emf.createEntityManager();
		
		Student student = new Student();
		student.setFirstName("Anirudh");
		student.setEmail("venkyveeru@gmail.com@");
		
		Student student1 = new Student();
		student1.setFirstName("Mahesh");
		student1.setEmail("gonemaheshkumar@gmail.com");
		
		List<Student> list = new ArrayList();

		list.add(student1);
		
		Course course = new Course();
		course.setCourseName("Spring MVC");
		course.setInstructor("Chris");
		
		Course course1 = new Course();
		course1.setCourseName("JPA");
		course1.setInstructor("Martha");
		
		List<Course> list1 = new ArrayList();
		list1.add(course1);
		
		course.setStudents(list);

		
		try {
			
			em.getTransaction().begin();
//			
			System.out.println("Saving the Course 1 ");
			em.persist(student1);
			em.persist(course);
			
			System.out.println("Saving the Student 1 ");
			student.setCourses(list1);
			em.persist(course1);
			em.persist(student);
			
			
			em.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}

	}

}
