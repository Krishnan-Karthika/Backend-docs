package com.orthofx.Company.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orthofx.Company.dto.EmployeePostDto;
import com.orthofx.Company.dto.EmployeeUpdateDto;
import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.model.Employee;
import com.orthofx.Company.service.CompanyService;
import com.orthofx.Company.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//create employee
	@PostMapping("/company/{id}/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeePostDto employeeDto, @PathVariable(value="id") Long id)throws ResourceNotFoundException{	
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employeeDto, id), HttpStatus.CREATED);
	}
	//get all
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	//getByEID
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
		return new ResponseEntity<Employee>(employeeService.getByEmployeeId(id) , HttpStatus.OK);
	}	
	//updateEmployee
	@PutMapping("/employee/{id}")	
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody EmployeeUpdateDto employeeDto) throws ResourceNotFoundException {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employeeDto, id),HttpStatus.OK);
	}		
	//deleteEmployeeByID
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
	}		
	//deleteByCompanyId	
	@Transactional
	@DeleteMapping("/company/{id}/employee")
	public ResponseEntity<String> deleteByCID(@PathVariable(value="companyId") Long id) throws ResourceNotFoundException{
		employeeService.deleteByCompanyId(id);
		return new ResponseEntity<String>("Deleted all the employees of selected company", HttpStatus.OK);
	}
	
}
