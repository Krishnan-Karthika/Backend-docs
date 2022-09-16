package com.orthofx.Company.service;

import java.util.List;

import com.orthofx.Company.dto.EmployeePostDto;
import com.orthofx.Company.dto.EmployeeUpdateDto;
import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(EmployeePostDto employeeDto, Long id) throws ResourceNotFoundException;        //SAVE
	Employee updateEmployee(EmployeeUpdateDto employeeDto,Long id) throws ResourceNotFoundException;     //UPDATE
	List<Employee> getAllEmployees();                                                                    //GET ALL
	Employee getByEmployeeId(Long id) throws ResourceNotFoundException;                                  //GET BY ID	
	void deleteEmployee(Long id)throws ResourceNotFoundException;                                        
	void deleteByCompanyId(Long id)throws ResourceNotFoundException;
}
