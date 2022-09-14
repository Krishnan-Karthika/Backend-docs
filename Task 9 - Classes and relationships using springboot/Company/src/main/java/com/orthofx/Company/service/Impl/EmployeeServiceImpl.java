package com.orthofx.Company.service.Impl;

import org.springframework.stereotype.Service;

import com.orthofx.Company.model.Employee;
import com.orthofx.Company.repository.EmployeeRepository;
import com.orthofx.Company.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
