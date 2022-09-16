package com.orthofx.Company.dto;



public class EmployeePostDto {
	private Long id;
	private String firstName;
	private String lastName;	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public EmployeePostDto(Long id, String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		}
	
	public EmployeePostDto() {
		super();
	}
//	public void setCompany(CompanyGetAllDto companyDto) {
//		this.setCompanyDto(companyDto);
//		
//	}
//	public CompanyGetAllDto getCompanyDto() {
//		return companyDto;
//	}
//	public void setCompanyDto(CompanyGetAllDto companyDto) {
//		this.companyDto = companyDto;
//	}
}
