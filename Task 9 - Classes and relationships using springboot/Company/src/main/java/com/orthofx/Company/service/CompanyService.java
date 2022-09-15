package com.orthofx.Company.service;

import java.util.List;
import java.util.Set;

import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.model.Employee;

public interface CompanyService {
	
	Company saveCompany(Company company);
	
	List<Company> getAllCompanies();
	
	Company getCompanyById(Long id) throws ResourceNotFoundException;
	
	Set<Employee> getEmployeesByCompanyId(Long id) throws ResourceNotFoundException;
	
	Company updateCompany(Company company,Long id) throws ResourceNotFoundException;
	
	void deleteCompany(Long id)throws ResourceNotFoundException;
}
