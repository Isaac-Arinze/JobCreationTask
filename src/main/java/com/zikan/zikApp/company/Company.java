package com.zikan.zikApp.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zikan.zikApp.job.Job;
import com.zikan.zikApp.review.Review;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table (name = "company")
public class Company {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String description;

//    we need to map the company to jobs
    @JsonIgnore
    @OneToMany (mappedBy = "company")
    private List<Job> jobs;

    @JsonIgnore
    @OneToMany (mappedBy = "company")
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}