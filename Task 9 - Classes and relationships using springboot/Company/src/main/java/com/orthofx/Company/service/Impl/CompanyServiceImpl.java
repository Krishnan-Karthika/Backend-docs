package com.orthofx.Company.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.orthofx.Company.dto.CompanyDto;
import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.model.Employee;
import com.orthofx.Company.repository.CompanyRepository;
import com.orthofx.Company.repository.EmployeeRepository;
import com.orthofx.Company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	private CompanyRepository companyRepository;
	private EmployeeRepository employeeRepository;
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public Company saveCompany(CompanyDto companyDto) {
		return companyRepository.save(companyDto);
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public Company getCompanyById(Long id)throws ResourceNotFoundException{
		return companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
	}
	
	@Override
	public Set<Employee> getEmployeesByCompanyId(Long id) throws ResourceNotFoundException {
		Company company = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
		return company.getEmployee();
	}

//	@Override
//	public List<Company> getEmployeesByCid(Long id) throws ResourceNotFoundException {
//		List<Company> company = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
//		return company;
//	}
	
//	@Override
//	public List<Employee> getEmployeesByCompanyId(Long id) throws ResourceNotFoundException {
//		return (List<Employee>) companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
//	}

	@Override
	public Company updateCompany(Company company, Long id)throws ResourceNotFoundException {
		Company existingCompany = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
		existingCompany.setCompanyName(company.getCompanyName());
		companyRepository.save(existingCompany);
		return existingCompany;
	}

	@Override
	public void deleteCompany(Long id)throws ResourceNotFoundException {
		companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
		companyRepository.deleteById(id);		
	}

		
}
