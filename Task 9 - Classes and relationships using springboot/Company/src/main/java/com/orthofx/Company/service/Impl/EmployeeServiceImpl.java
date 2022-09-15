package com.orthofx.Company.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee, Long id) throws ResourceNotFoundException{
		return companyRepository.findById(id).map(company -> {
		employee.setCompany(company);
		return employeeRepository.save(employee);
			}).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
		
		
	}
	
	//employee.setLastName(employee.getLastName());
			//employee.setFirstName(employee.getFirstName());
	
	//@PostMapping("/companies/{companyId}/employee")
//public Employee creteEmployee(@Validated @RequestBody Employee employee,@RequestBody Company companyDetails, @PathVariable Long companyId) throws ResourceNotFoundException {
//	Company company = companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));
//	employee.setCompany(companyDetails.getCompany());
//	return employeeRepository.save(employee);
//}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getByEmployeeId(Long id) throws ResourceNotFoundException {
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) throws ResourceNotFoundException {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setFirstName(employee.getFirstName());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(Long id)throws ResourceNotFoundException {
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		employeeRepository.deleteById(id);		
	}
	
}
