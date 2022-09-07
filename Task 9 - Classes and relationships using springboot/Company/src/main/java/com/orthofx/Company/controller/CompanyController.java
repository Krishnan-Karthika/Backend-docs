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
@RequestMapping("/api/primaryClass/")
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;
	
		//get(select company details)
		@GetMapping("/allCompanies")
		public List<Company> getAllCompany() {
			return companyRepository.findAll();
		}
		
		//get(select company details by id)
		@GetMapping("/company/{companyId}")
		public ResponseEntity<Company> getCompanyById(@PathVariable(value = "companyId") Long companyId)
				throws ResourceNotFoundException {
			Company company = companyRepository.findById(companyId)
					.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));
			return ResponseEntity.ok().body(company);
		}
		
//		@GetMapping("/company/{id}")
//		public Optional<Company> get(@PathVariable Long companyId) {
//			return companyRepository.findById(companyId);
//		}
		
		//save(insert) company
//		@PostMapping("/newCompany/")
//		@RequestMapping(method=RequestMethod.POST)
		
		@RequestMapping(value="company",method=RequestMethod.POST)
		public Company createCompany(@Validated @RequestBody Company company) {
			return companyRepository.save(company);
		}
		
		//update company
//		@PutMapping("/company/{companyId}")
		@RequestMapping(value = "company/{companyId}", method = RequestMethod.PUT)
		public ResponseEntity<Company> updateCompany(@PathVariable(value = "companyId") Long companyId,
				@Validated @RequestBody Company companyDetails) throws ResourceNotFoundException {
			Company company = companyRepository.findById(companyId)
					.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));
			company.setCompanyID(companyDetails.getCompanyID());
			company.setCompanyName(companyDetails.getCompanyName());
			final Company updatedCompany = companyRepository.save(company);
			return ResponseEntity.ok(updatedCompany);
		}
		
//		@RequestMapping(value = "company/{companyId}", method = RequestMethod.PUT)
//		public Company update(@RequestBody Company company,@PathVariable Long id) {
//			Company updateCompany = companyRepository.findById(id).get();
//			updateCompany.setCompanyName(updateCompany.getCompanyName());
//			return companyRepository.save(updateCompany);
//		}		
		
		
		//delete company
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
		
//		@DeleteMapping("/company/{id}")
//		@RequestMapping(method = RequestMethod.DELETE)
		
//		@RequestMapping(value="deleteEngine/{id}", method = RequestMethod.DELETE)
//		public void delete(@PathVariable Long id) {
//			companyRepository.deleteById(id);
//		}

}
