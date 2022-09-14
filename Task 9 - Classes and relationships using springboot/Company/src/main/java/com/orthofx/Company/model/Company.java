package com.orthofx.Company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private String companyName;
	
	@OneToMany
	private Employee employee;	
	
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
	
	
}
