package com.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity
@Table(name="course")
public class Course {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int course_id;
	private String courseName;
	private String instructor;

	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			)
	private List<Student> students;

	public Course() {
		super();
	}
	
	
	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public int getCourse_id() {
		return this.course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", courseName=" + courseName + ", instructor=" + instructor + "]";
	}


}
