package com.yash.jobtrackr.service;

import com.yash.jobtrackr.model.Job;
import com.yash.jobtrackr.model.JobStatus;
import com.yash.jobtrackr.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get job by ID
    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    // Get jobs by status
    public List<Job> getJobsByStatus(JobStatus status) {
        return jobRepository.findByStatus(status);
    }

    // Create new job
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    // Update job
    public Job updateJob(Long id, Job updatedJob) {
        return jobRepository.findById(id).map(job -> {
            job.setCompanyName(updatedJob.getCompanyName());
            job.setPosition(updatedJob.getPosition());
            job.setStatus(updatedJob.getStatus());
            job.setNotes(updatedJob.getNotes());
            job.setAppliedDate(updatedJob.getAppliedDate());
            return jobRepository.save(job);
        }).orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
    }

    // Delete job
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    // Analytics — count by status
    public long countByStatus(JobStatus status) {
        return jobRepository.findByStatus(status).size();
    }
}