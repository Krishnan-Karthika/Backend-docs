package com.orthofx.Company.controller;

import java.util.List;import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orthofx.Company.exception.ResourceNotFoundException;
import com.orthofx.Company.model.Company;
import com.orthofx.Company.model.Employee;
import com.orthofx.Company.service.CompanyService;
import com.orthofx.Company.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	private CompanyService companyService;
//	private EmployeeRepository employeeRepository;
		
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//create employee
	@PostMapping("/company/{id}/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee, @PathVariable(value="id") Long id)throws ResourceNotFoundException{
		//Company company=companyService.getCompanyById(id);		
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee, id), HttpStatus.CREATED);
	}
	
	//get all
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	//getByEID
	@GetMapping("employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
		return new ResponseEntity<Employee>(employeeService.getByEmployeeId(id) , HttpStatus.OK);
	}
	
	//updateCompany
	@PutMapping("employee/{id}")	
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee employee) throws ResourceNotFoundException {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
		
	//deleteCompany
	@DeleteMapping("employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
	}
	
	
	
	
	
//	//getByCompanyId
//	@GetMapping("/company/{companyId}/employee")
//	public List<Employee> getAll(@PathVariable(value="companyId") Long companyId) throws ResourceNotFoundException {
//		List<Employee> employee = new ArrayList<>();
//		employeeRepository.findByid(companyId).forEach(employee::add);
//		return employee;
//	}
//		
////	//insert
////	@PostMapping("/companies/{companyId}/employee")
////	public Employee createEmployee(@Validated @RequestBody Employee employee, @PathVariable Long companyId,String companyName) {
////		employee.setCompany(new Company(companyId,companyName));
////		return employeeRepository.save(employee);
////	}
//	
////	//insert
////		@PostMapping("/companies/{companyId}/employee")
////		public Employee creteEmployee(@Validated @RequestBody Employee employee,@RequestBody Company companyDetails, @PathVariable Long companyId) throws ResourceNotFoundException {
////			Company company = companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));
////			employee.setCompany(companyDetails.getCompany());
////			return employeeRepository.save(employee);
////		}
//		
//	//deleteByEID
//	@DeleteMapping("/companies/{companyId}/employee/{id}")
//	public Map<String, Boolean> deleteeEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
//		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//		employeeRepository.delete(employee);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return response;
//	}
//	
//	//deleteBycompanyId
//	@Transactional
//	@DeleteMapping("/companies/{companyId}/employee")
//	public void deleteByCID(@PathVariable(value="companyId") Long companyId){
//		employeeRepository.deleteByid(companyId);
//	}
//	
	//update employee
//	@PutMapping("/companies/{companyId}/employee/{id}")	
//	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="companyId") Long companyId, @PathVariable(value="id")Long employeeId,@Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
//		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setFirstName(employeeDetails.getFirstName());
//		final Employee updatedEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}	
	
	
	
}
