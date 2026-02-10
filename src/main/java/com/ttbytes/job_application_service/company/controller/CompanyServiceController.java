package com.ttbytes.job_application_service.company.controller;

import com.ttbytes.job_application_service.company.model.Company;
import com.ttbytes.job_application_service.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyServiceController {

    private final CompanyService companyService;

    @GetMapping("/getCompanies")
    public ResponseEntity<List<Company>> getCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping("/createCompany")
    public ResponseEntity<String> createCompanyRecord(@RequestBody Company newCompany){
        companyService.createCompany(newCompany);
        return new ResponseEntity<>("Company added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/updateCompany/{id}")
    public ResponseEntity<String> updateCompanyRecord(@PathVariable Long id, @RequestBody Company company){
        companyService.updateCompany(id,company);
        return new ResponseEntity<>("Company record updated successfully",HttpStatus.OK);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        companyService.deleteCompanyById(id);
        return new ResponseEntity<>("Company record removed successfully", HttpStatus.OK);
    }

    @GetMapping("/getcompanybyid/{id}")
    public ResponseEntity<Company> getCompanyById(Long id){
        Company companyById = companyService.getCompanyById(id);
        if(companyById!=null){
            return new ResponseEntity<>(companyById, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
