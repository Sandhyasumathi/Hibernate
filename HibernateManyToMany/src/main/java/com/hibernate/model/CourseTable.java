package com.hibernate.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class CourseTable {

	@Id
	private int cid;
	private String cname;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<StudentsTable> studentList;



	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<StudentsTable> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<StudentsTable> studentList) {
		this.studentList = studentList;
	}
	
	@Override
	public String toString() {
		return "CourseTable [cid=" + cid + ", cname=" + cname + ", studentList=" + studentList + "]";
	}
}
