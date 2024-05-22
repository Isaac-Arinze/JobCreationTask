package com.zikan.zikApp.job.impl;

import com.zikan.zikApp.job.Job;
import com.zikan.zikApp.job.JobRepository;
import com.zikan.zikApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JobServiceImpl implements JobService {

//    private List<Job> jobs = new ArrayList<>();

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

//    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
//        job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobsById(Long id) {
            if (jobRepository.existsById(id)){
                jobRepository.deleteById(id);
                return true;
            }
            else {
                return false;
            }



//        Job isDeleted = jobRepository.deleteById(id);

//        try {
//            jobRepository.deleteById(id);
//            return true;
//        } catch (Exception exception) {
//            System.out.println(exception.getMessage());
//        }
//        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job updateJob) {

        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()) {
            Job job = jobOptional.get();

            job.setTitle(updateJob.getTitle());
            job.setDescription(updateJob.getDescription());
            job.setMinSalary(updateJob.getMinSalary());
            job. setMaxSalary(updateJob.getMaxSalary());
            job.setLocation(updateJob.getLocation());

            jobRepository.save(job);

            return true;
        }
        return false;

    }

}
