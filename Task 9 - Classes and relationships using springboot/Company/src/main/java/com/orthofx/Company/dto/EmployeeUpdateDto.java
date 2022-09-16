package com.orthofx.Company.dto;

public class EmployeeUpdateDto {
	private Long id;
	private String firstName;
	private String LastName;
	
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
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public EmployeeUpdateDto(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		LastName = lastName;
	}
	public EmployeeUpdateDto() {
		super();
	}
	
	
	

}
