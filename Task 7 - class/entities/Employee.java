package com.orthofx.entities;

public class Employee {
	private int id;
	private String name;
	private Company company;
	
	public Employee(int id,String name,Company company) {
		this.id=id;
		this.name=name;
		this.company=company;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;				
	}
	
	public String getCompanyName() {
		return company.getName();
	}
}
