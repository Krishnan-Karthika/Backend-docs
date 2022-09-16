package com.orthofx.Company.dto;

import java.util.List;
import java.util.Set;

import com.orthofx.Company.model.Employee;


public class EmployeeGetAllDto {
	
	private List<Employee> allEmployee;

	public List<Employee> getAllEmployee() {
		return allEmployee;
	}
	public void setAllEmployee(List<Employee> allEmployee) {
		this.allEmployee = allEmployee;
	}
	

}
