package com.zikan.zikApp.job.impl;

import com.zikan.zikApp.job.Job;
import com.zikan.zikApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();

    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }
    @Override

    public Job getJobById(Long id) {
        for (Job myJob : jobs) {
            if (myJob.getId().equals(id))
                return myJob;
        }
        return null;
    }

    @Override
    public boolean deleteJobsById(Long id) {
        Iterator<Job> iterator = jobs.iterator();

        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(id)) ;
            iterator.remove();
            return true;
        }
        return false;

    }

    @Override
    public boolean updateJobById(Long id, Job updateJob) {

        Iterator <Job> iterator = jobs.iterator();
        List <Job> update = new ArrayList<>();

        while (iterator.hasNext()){
            Job job = (Job) jobs.iterator();
            if(job.getId().equals(id));
            update.add(job);

            return true;
        }
        return false;

    }

}