package com.orthofx.Company.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.model.Employee;
import com.orthofx.Company.repository.CompanyRepository;
import com.orthofx.Company.service.CompanyService;
import com.orthofx.Company.service.EmployeeService;

@RestController
@RequestMapping("/api/company/")
public class CompanyController {
	
	private CompanyService companyService; 
	
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	//create employee
	@PostMapping
	public ResponseEntity<Company> saveCompany(@RequestBody Company company){
		return new ResponseEntity<Company>(companyService.saveCompany(company),HttpStatus.CREATED);
	}
	
	//getAll
	@GetMapping
	public List<Company> getAllCompanies(){
		return companyService.getAllCompanies();
	}
	
	//getById
	@GetMapping("{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable(value = "id") Long id)throws ResourceNotFoundException {
		return new ResponseEntity<Company>(companyService.getCompanyById(id) , HttpStatus.OK);
	}
	
	//updateCompany
	@PutMapping("{id}")	
	public ResponseEntity<Company> updateCompany(@PathVariable(value = "id") Long id, @RequestBody Company company) throws ResourceNotFoundException {
		return new ResponseEntity<Company>(companyService.updateCompany(company, id), HttpStatus.OK);
	}
	
	//deleteCompany
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		companyService.deleteEmployee(id);
		return new ResponseEntity<String>("Company deleted successfully", HttpStatus.OK);
	}
}
