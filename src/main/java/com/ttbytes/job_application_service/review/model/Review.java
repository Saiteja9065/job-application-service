package com.ttbytes.job_application_service.review.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ttbytes.job_application_service.company.model.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double rating;

    @ManyToOne
    @JsonIgnore
    private Company company;

    protected Review(){}

    public Review(String title, String description, double rating, Company company){
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.company = company;
    }
}
