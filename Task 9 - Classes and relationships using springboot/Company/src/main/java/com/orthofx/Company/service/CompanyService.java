package com.orthofx.Company.service;

import java.util.List;

import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;

public interface CompanyService {
	Company saveCompany(Company company);
	List<Company> getAllCompanies();
	Company getCompanyById(Long id) throws ResourceNotFoundException;
	Company updateCompany(Company company,Long id) throws ResourceNotFoundException;
	void deleteEmployee(Long id)throws ResourceNotFoundException;
}
