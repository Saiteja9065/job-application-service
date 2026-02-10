package com.ttbytes.job_application_service.company.repository;

import com.ttbytes.job_application_service.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
