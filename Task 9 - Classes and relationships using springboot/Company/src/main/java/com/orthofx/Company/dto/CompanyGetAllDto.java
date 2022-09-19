package com.orthofx.Company.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.orthofx.Company.model.Company;
import com.orthofx.Company.model.Employee;

public class CompanyGetAllDto {
	
		private List<Company> allCompany;
		private Set<Employee> employee = new HashSet<>();
		
		
		public List<Company> getAllCompany() {
			return allCompany;
		}

		public void setAllCompany(List<Company> allCompany) {
			this.allCompany = allCompany;
		}

		public Set<Employee> getEmployee() {
			return employee;
		}

		public void setEmployee(Set<Employee> employee) {
			this.employee = employee;
		}

		public CompanyGetAllDto() {
			super();
		}
		
}
