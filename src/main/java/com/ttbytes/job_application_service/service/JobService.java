package com.ttbytes.job_application_service.service;

import com.ttbytes.job_application_service.model.JobPosts;

import java.util.List;

public interface JobService {

    List<JobPosts> findAll();

    void createJob(JobPosts job);

    JobPosts getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, JobPosts job);
}
