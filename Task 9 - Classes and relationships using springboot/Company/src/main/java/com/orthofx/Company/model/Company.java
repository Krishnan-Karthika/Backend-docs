package com.orthofx.Company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="companyTable")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long companyID;	
	
	@Column(name="companyName")
	private String companyName;
	
	public Company() {
		super();
	}	

	public Company(String companyName) {
		super();
		this.companyName = companyName;
	}

	public Company(long companyID, String companyName) {
		super();
		this.companyID = companyID;
		this.companyName = companyName;
	}
	
	public long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	

}
