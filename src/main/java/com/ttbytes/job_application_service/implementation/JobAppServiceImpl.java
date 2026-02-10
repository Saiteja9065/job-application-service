package com.ttbytes.job_application_service.implementation;

import com.ttbytes.job_application_service.company.model.Company;
import com.ttbytes.job_application_service.company.repository.CompanyRepository;
import com.ttbytes.job_application_service.model.JobPosts;
import com.ttbytes.job_application_service.repository.JobPostsRepository;
import com.ttbytes.job_application_service.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobAppServiceImpl implements JobService {

    private final JobPostsRepository jobPostsRepository;

    private final CompanyRepository companyRepository;

    @Override
    public List<JobPosts> findAll() {
        return jobPostsRepository.findAll();
    }

    @Override
    public void createJob(JobPosts job) {

        Company company = companyRepository.findById(job.getCompany().getId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        JobPosts newJob = new JobPosts(
                job.getTitle(),
                job.getDescription(),
                job.getMinSalary(),
                job.getMaxSalary(),
                job.getLocation(),
                company
        );

        jobPostsRepository.save(newJob);
    }


    @Override
    public JobPosts getJobById(Long id) {
        return jobPostsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    @Override
    public boolean deleteJobById(Long id) {
        if (!jobPostsRepository.existsById(id)) {
            return false;
        }
        jobPostsRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateJob(Long id, JobPosts job) {
        Optional<JobPosts> existingJob = jobPostsRepository.findById(id);
        Company company = companyRepository.findById(job.getCompany().getId())
                .orElseThrow(() -> new RuntimeException("Company not found"));
        if(existingJob.isPresent()){
            JobPosts updatedJob = existingJob.get();
            updatedJob.setDescription(job.getDescription());
            updatedJob.setTitle(job.getTitle());
            updatedJob.setMinSalary(job.getMinSalary());
            updatedJob.setMaxSalary(job.getMaxSalary());
            updatedJob.setLocation(job.getLocation());
            updatedJob.setCompany(company);
            jobPostsRepository.save(job);
            return true;
        }
        return false;
    }
}
