package com.dk.first.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employee")
public class employee {

	@Id
	private int id;
	private String name;
	private String designation;
	private String location;
	
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	public employee(int id, String name, String designation, String location) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.location = location;
	}
	
	
	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", designation=" + designation + ", location=" + location
				+ "]";
	}

	
	
}
