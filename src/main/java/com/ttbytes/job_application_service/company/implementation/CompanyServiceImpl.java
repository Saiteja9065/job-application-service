package com.ttbytes.job_application_service.company.implementation;

import com.ttbytes.job_application_service.company.model.Company;
import com.ttbytes.job_application_service.company.repository.CompanyRepository;
import com.ttbytes.job_application_service.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company){
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Long id, Company updatedCompany){
        Optional<Company> companyRecord = companyRepository.findById(id);
        if(companyRecord.isPresent()){
            Company updateCompany = companyRecord.get();
            updateCompany.setDescription(updatedCompany.getDescription());
            updateCompany.setName(updatedCompany.getName());
            updateCompany.setJobPostsList(updatedCompany.getJobPostsList());
            companyRepository.save(updateCompany);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(Long id){
        Optional<Company> companyRecord = companyRepository.findById(id);
        if(companyRecord.isPresent()){
            companyRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id){
        return companyRepository.findById(id).orElseThrow(()-> new RuntimeException("Company not found"));
    }




}
