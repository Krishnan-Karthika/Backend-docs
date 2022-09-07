package com.orthofx.Company.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.repository.CompanyRepository;

@RestController
@RequestMapping("/api/company/")
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;
	
		//getAll
		@GetMapping("/allCompanies")
		public List<Company> getAllCompany() {
			return companyRepository.findAll();
		}
		
		//getByID
		@GetMapping("/company/{companyId}")
		public ResponseEntity<Company> getCompanyById(@PathVariable(value = "companyId") Long companyId)
				throws ResourceNotFoundException {
			Company company = companyRepository.findById(companyId)
					.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));
			return ResponseEntity.ok().body(company);
		}
		

		@RequestMapping(value="company",method=RequestMethod.POST)
		public Company createCompany(@Validated @RequestBody Company company) {
			return companyRepository.save(company);
		}
		
		//update
		@RequestMapping(value = "/company/{companyId}", method = RequestMethod.PUT)
		public ResponseEntity<Company> updateCompany(@PathVariable(value = "companyId") Long companyId,
				@Validated @RequestBody Company companyDetails) throws ResourceNotFoundException {
			Company company = companyRepository.findById(companyId)
					.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));
			company.setCompanyID(companyDetails.getCompanyID());
			company.setCompanyName(companyDetails.getCompanyName());
			final Company updatedCompany = companyRepository.save(company);
			return ResponseEntity.ok(updatedCompany);
		}

		//delete
		@DeleteMapping("/company/{companyId}")
		@RequestMapping(value="company/{companyId}", method = RequestMethod.DELETE)
		public Map<String, Boolean> deleteCompany(@PathVariable(value = "companyId") Long companyId)
				throws ResourceNotFoundException {
			Company company = companyRepository.findById(companyId)
					.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));

			companyRepository.delete(company);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}

}
