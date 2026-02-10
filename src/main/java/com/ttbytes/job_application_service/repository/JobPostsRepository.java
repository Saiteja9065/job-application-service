package com.ttbytes.job_application_service.repository;

import com.ttbytes.job_application_service.model.JobPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostsRepository extends JpaRepository<JobPosts, Long> {

}
