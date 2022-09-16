package com.orthofx.Company.dto;

import com.orthofx.Company.model.Employee;

public class EmployeeGetByIdDto {
	
	private Employee employeeById;

	public Employee getEmployeeById() {
		return employeeById;
	}

	public void setEmployeeById(Employee employeeById) {
		this.employeeById = employeeById;
	}

}
