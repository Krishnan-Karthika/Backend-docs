package com.orthofx.Company.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.orthofx.Company.dto.CompanyGetAllDto;
import com.orthofx.Company.dto.CompanyPostDto;
import com.orthofx.Company.dto.CompanyUpdateDto;
import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.model.Employee;

public interface CompanyService {
	
	Company saveCompany(CompanyPostDto companyDto);	                                                    //SAVE
	Company updateCompany(CompanyUpdateDto CompanyDto,Long id) throws ResourceNotFoundException;        //UPDATE
	List<Company> getAllCompanies();                                                                    //GET ALL
	Company getCompanyById(Long id) throws ResourceNotFoundException;                                   //GET BY ID
	List<Employee> getEmployeesByCompanyId(Long id) throws ResourceNotFoundException;                    //GET EMPLOYEES BY CID
	void deleteCompany(Long id)throws ResourceNotFoundException;

}