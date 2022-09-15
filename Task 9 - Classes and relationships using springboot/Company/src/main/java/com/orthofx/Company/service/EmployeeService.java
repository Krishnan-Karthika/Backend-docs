package com.orthofx.Company.service;

import java.util.List;

import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee, Long id) throws ResourceNotFoundException;
	List<Employee> getAllEmployees();
	Employee getByEmployeeId(Long id) throws ResourceNotFoundException;
	Employee updateEmployee(Employee employee,Long id) throws ResourceNotFoundException;
	void deleteEmployee(Long id)throws ResourceNotFoundException;

}
