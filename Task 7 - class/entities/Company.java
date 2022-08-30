package com.orthofx.entities;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private int id;
	private String name;
	private List<Employee> employees=new ArrayList<>();
	
	public Company(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
