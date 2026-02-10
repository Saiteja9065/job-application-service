package com.ttbytes.job_application_service.controller;



import com.ttbytes.job_application_service.model.JobPosts;
import com.ttbytes.job_application_service.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobs")
public class JobAppController {

    private final JobService jobService;

    @GetMapping("/getAllJobs")
    public ResponseEntity<List<JobPosts>> getAllJobs(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/job")
    public ResponseEntity<String> createJob(@RequestBody JobPosts jobPosts){
        jobService.createJob(jobPosts);
        return new ResponseEntity<>("Job added succesfully", HttpStatus.CREATED);
    }

    @PutMapping("/updateJob/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody JobPosts updatedJob){
        boolean updatedJobPost = jobService.updateJob(id, updatedJob);
        if(updatedJobPost){
            return new ResponseEntity<>("Job Post Updated successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long Id){
        boolean deletePost = jobService.deleteJobById(Id);
        if(deletePost){
            return new ResponseEntity<>("Job Post has been removed successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<JobPosts> getJobById(@PathVariable Long Id){
        JobPosts job = jobService.getJobById(Id);
        if(job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
