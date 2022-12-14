package com.orthofx.Company.controller;

import java.util.List;
import java.util.Set;

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

import com.orthofx.Company.dto.CompanyGetAllDto;
import com.orthofx.Company.dto.CompanyPostDto;
import com.orthofx.Company.dto.CompanyUpdateDto;
import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.model.Employee;
import com.orthofx.Company.service.CompanyService;

@RestController
@RequestMapping("/api")
public class CompanyController {
	@Autowired
	private CompanyService companyService; 
	
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	//createCompanyDTO
	@PostMapping("/company")
	public ResponseEntity<Company> saveCompany(@RequestBody CompanyPostDto companyDto){
		return new ResponseEntity<Company>(companyService.saveCompany(companyDto),HttpStatus.CREATED);
	}
	//getAllDTO
	@GetMapping("/companies")
	public List<Company> getAllCompanies(){
		return companyService.getAllCompanies();
	}
	//getByIdDto
	@GetMapping("/company/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable(value = "id") Long id)throws ResourceNotFoundException {
		return new ResponseEntity<Company>(companyService.getCompanyById(id) , HttpStatus.OK);
	}
	//getEmployeeByCid
	@GetMapping("/company/{id}/employee")
	public List<Employee> getEmployeeByCompanyId(@PathVariable(value = "id") Long id)throws ResourceNotFoundException {
		return companyService.getEmployeesByCompanyId(id);
	}	
	//updateCompany
	@PutMapping("/company/{id}")	
	public ResponseEntity<Company> updateCompany(@PathVariable(value = "id") Long id, @RequestBody CompanyUpdateDto companyDto) throws ResourceNotFoundException {
		return new ResponseEntity<Company>(companyService.updateCompany(companyDto, id), HttpStatus.OK);
	}
	//deleteCompany
	@DeleteMapping("/company/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		companyService.deleteCompany(id);
		return new ResponseEntity<String>("Company deleted successfully", HttpStatus.OK);
	}

}
