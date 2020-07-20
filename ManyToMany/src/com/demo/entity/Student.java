package com.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
@Table(name="student")
public class Student{

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int student_id;
	private String firstName;
	private String email;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="student_id"),
			inverseJoinColumns=@JoinColumn(name="course_id")
			)
	private List<Course> courses;

	public Student() {
		super();
	}   
	public int getStudent_id() {
		return this.student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", firstName=" + firstName + ", email=" + email + "]";
	}
	
	
   
}
