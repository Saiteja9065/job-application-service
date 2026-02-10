package com.ttbytes.job_application_service.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ttbytes.job_application_service.model.JobPosts;
import com.ttbytes.job_application_service.review.model.Review;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company_table")
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<JobPosts> jobPostsList = new ArrayList<>();

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Review> companyReviews = new ArrayList<>();

    public Company(){}

    public Company(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
