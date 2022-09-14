package com.orthofx.Company.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.repository.CompanyRepository;
import com.orthofx.Company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	private CompanyRepository companyRepository;	
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public Company saveCompany(Company company) {
		return companyRepository.save(company);
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
	public Company updateCompany(Company company, Long id)throws ResourceNotFoundException {
		Company existingCompany = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
		existingCompany.setCompanyName(company.getCompanyName());
		companyRepository.save(existingCompany);
		return existingCompany;
	}

	@Override
	public void deleteEmployee(Long id)throws ResourceNotFoundException {
		companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));
		companyRepository.deleteById(id);		
	}
}
