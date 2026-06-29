package com.yash.jobtrackr.controller;

import com.yash.jobtrackr.model.Job;
import com.yash.jobtrackr.model.JobStatus;
import com.yash.jobtrackr.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // GET all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    // GET job by ID
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        return jobService.getJobById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET jobs by status
    @GetMapping("/status/{status}")
    public List<Job> getJobsByStatus(@PathVariable JobStatus status) {
        return jobService.getJobsByStatus(status);
    }

    // POST create new job
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    // PUT update job
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job) {
        return ResponseEntity.ok(jobService.updateJob(id, job));
    }

    // DELETE job
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    // GET analytics
    @GetMapping("/analytics")
    public Map<String, Long> getAnalytics() {
        Map<String, Long> analytics = new HashMap<>();
        analytics.put("applied", jobService.countByStatus(JobStatus.APPLIED));
        analytics.put("interview", jobService.countByStatus(JobStatus.INTERVIEW));
        analytics.put("offer", jobService.countByStatus(JobStatus.OFFER));
        analytics.put("rejected", jobService.countByStatus(JobStatus.REJECTED));
        analytics.put("total", (long) jobService.getAllJobs().size());
        return analytics;
    }
}