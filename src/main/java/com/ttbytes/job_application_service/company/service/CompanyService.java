package com.ttbytes.job_application_service.company.service;

import com.ttbytes.job_application_service.company.model.Company;
import com.ttbytes.job_application_service.model.JobPosts;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void createCompany(Company company);

    boolean updateCompany(Long id, Company company);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);
}
