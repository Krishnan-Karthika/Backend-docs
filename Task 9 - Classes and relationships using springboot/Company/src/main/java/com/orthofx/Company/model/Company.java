package com.orthofx.Company.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name="company_name")
	private String companyName;
	
	@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "company")
    private List<Employee> employee = new ArrayList<>();
	
	public Company() {
		super();
	}
	public Company(String companyName) {
		super();
		this.companyName = companyName;
	}
	public Company(Long id, String companyName) {
		super();
		this.id = id;
		this.companyName = companyName;
	}	
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}
