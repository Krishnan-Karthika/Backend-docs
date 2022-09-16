package com.orthofx.Company.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orthofx.Company.dto.CompanyGetAllDto;
import com.orthofx.Company.dto.EmployeeGetAllDto;
import com.orthofx.Company.dto.EmployeeGetByIdDto;
import com.orthofx.Company.dto.EmployeePostDto;
import com.orthofx.Company.dto.EmployeeUpdateDto;
import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.model.Employee;
import com.orthofx.Company.repository.CompanyRepository;
import com.orthofx.Company.repository.EmployeeRepository;
import com.orthofx.Company.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override   //POST
	public Employee saveEmployee(EmployeePostDto employeeDto, Long id) throws ResourceNotFoundException{
		Company company = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
		Employee employee = new Employee();
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setCompany(company);
		return employeeRepository.save(employee);
	}
	@Override  //UPDATE
	public Employee updateEmployee(EmployeeUpdateDto employeeDto, Long id) throws ResourceNotFoundException {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		existingEmployee.setLastName(employeeDto.getLastName());
		existingEmployee.setFirstName(employeeDto.getFirstName());
		return employeeRepository.save(existingEmployee);
	}
	@Override  //GET ALL
	public List<Employee> getAllEmployees() {
		EmployeeGetAllDto employeeDto = new EmployeeGetAllDto();
		employeeDto.setAllEmployee(employeeRepository.findAll());
		return employeeDto.getAllEmployee();
	}
	@Override  //GET BY ID
	public Employee getByEmployeeId(Long id) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		EmployeeGetByIdDto employeeDto = new EmployeeGetByIdDto();
		employeeDto.setEmployeeById(employee);
		return employeeDto.getEmployeeById();
	}
	
	@Override  //DELETE BY ID
	public void deleteEmployee(Long id)throws ResourceNotFoundException {
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		employeeRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public void deleteByCompanyId(Long id) throws ResourceNotFoundException {
		
		
	}
}
