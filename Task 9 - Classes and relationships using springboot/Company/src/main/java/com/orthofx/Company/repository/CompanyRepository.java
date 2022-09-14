package com.orthofx.Company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.orthofx.Company.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
