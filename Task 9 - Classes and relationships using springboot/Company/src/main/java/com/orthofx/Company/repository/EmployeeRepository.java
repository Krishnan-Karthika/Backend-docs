package com.orthofx.Company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orthofx.Company.dto.EmployeePostDto;
import com.orthofx.Company.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	public List<Employee> findByid(Long employeeId);
	public void deleteByid(Long companyID);
	


}





