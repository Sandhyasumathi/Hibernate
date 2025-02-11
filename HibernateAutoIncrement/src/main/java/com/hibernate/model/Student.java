package com.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentInfo")
public class Student {
	
	@Id
	@GeneratedValue(generator = "customsqen", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "customsqen", sequenceName = "Sequenceone",initialValue = 50, allocationSize = 1)
	private int id;
	private String name;
	private String city;
	
	public Student() {
		System.out.println("Constructor for Student Hibernate");
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	

}
