package com.orthofx.Company.service.Impl;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orthofx.Company.dto.CompanyGetAllDto;
import com.orthofx.Company.dto.CompanyGetByIdDto;
import com.orthofx.Company.dto.CompanyPostDto;
import com.orthofx.Company.dto.CompanyUpdateDto;
import com.orthofx.Company.dto.EmployeeGetAllDto;
import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.model.Employee;
import com.orthofx.Company.repository.CompanyRepository;
import com.orthofx.Company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyRepository;

	@Override  //POST
	public Company saveCompany(CompanyPostDto companyDto) {
		Company company = new Company();
		company.setCompanyName(companyDto.getCompanyName());
		companyRepository.save(company);
		return company;
	}
	@Override  //UPDATE
	public Company updateCompany(CompanyUpdateDto companyDto, Long id) throws ResourceNotFoundException {
		Company company = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
		company.setCompanyName(companyDto.getCompanyName());
		companyRepository.save(company);
		return company;
	}
	@Override  //GET ALL
	public List<Company> getAllCompanies() {
		CompanyGetAllDto companyDto = new CompanyGetAllDto();	
		companyDto.setAllCompany(companyRepository.findAll());
		return companyDto.getAllCompany();		
	}
	@Override  //GET BY ID
	public Company getCompanyById(Long id) throws ResourceNotFoundException {
		Company company = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
		CompanyGetByIdDto companyDto = new CompanyGetByIdDto();
		companyDto.setCompanyById(company);
		return companyDto.getCompanyById();
	}
	@Override   //GET EMPLOYEES BY CID
	public List<Employee> getEmployeesByCompanyId(Long id) throws ResourceNotFoundException {		
		Company company = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
		EmployeeGetAllDto employeeDto = new EmployeeGetAllDto();
		employeeDto.setAllEmployee(company.getEmployee());
		return employeeDto.getAllEmployee();
	}	
	@Override   //DELETE
	public void deleteCompany(Long id)throws ResourceNotFoundException {
		companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
		companyRepository.deleteById(id);		
	}
}


