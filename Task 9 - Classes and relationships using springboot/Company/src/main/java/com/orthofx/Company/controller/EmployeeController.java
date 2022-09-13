package com.orthofx.Company.controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Employee;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.repository.EmployeeRepository;


@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all
	@GetMapping("/allEmployees")
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	//getByEID
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		return ResponseEntity.ok().body(employee);
	}
	//getByCompanyID
		@GetMapping("/{companyID}/employee")
		public List<Employee> getAll(@PathVariable(value="companyID") Long companyID){
			List<Employee> employee = new ArrayList<>();
			employeeRepository.findByCompanyCompanyID(companyID).forEach(employee::add);
			return employee;
		}
		
	//insert
	@PostMapping("/{companyId}/employee")
	public Employee createEmployee(@Validated @RequestBody Employee employee, @PathVariable Long companyId,String companyName) {
		employee.setCompany(new Company(companyId,companyName));
		return employeeRepository.save(employee);
	}
		
	//deleteByEID
	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	//deleteByCompanyID
	@Transactional
	@DeleteMapping("/{companyID}/employee")
	public void deleteByCID(@PathVariable(value="companyID") Long companyID){
		employeeRepository.deleteByCompanyCompanyID(companyID);
	}
	
	//update employee
		@RequestMapping(value="{companyID}/employee/{id}",method = RequestMethod.PUT)	
		public ResponseEntity<Employee> updateEmployee(@PathVariable(value="companyID") Long companyID, @PathVariable(value="id")Long employeeId,@Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
			Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
			employee.setLastName(employeeDetails.getLastName());
			employee.setFirstName(employeeDetails.getFirstName());
			final Employee updatedEmployee = employeeRepository.save(employee);
			return ResponseEntity.ok(updatedEmployee);
		}
	
	
	
}
