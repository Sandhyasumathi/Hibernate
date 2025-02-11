package com.hibernate.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class StudentsTable {

	@Id
	private int id;
	private String name;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<CourseTable> courseList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CourseTable> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<CourseTable> courseList) {
		this.courseList = courseList;
	}
	@Override
	public String toString() {
		return "StudentsTable [id=" + id + ", name=" + name  + "]";
	}
	
	
}
