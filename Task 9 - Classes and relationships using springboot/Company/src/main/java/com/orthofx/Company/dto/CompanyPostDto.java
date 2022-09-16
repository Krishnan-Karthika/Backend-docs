package com.orthofx.Company.dto;


public class CompanyPostDto {
	private Long companyId;
	private String companyName;
	
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public CompanyPostDto(String companyName) {
		super();
		this.companyName = companyName;
	}
	public CompanyPostDto() {
		super();
	}	
	
}
