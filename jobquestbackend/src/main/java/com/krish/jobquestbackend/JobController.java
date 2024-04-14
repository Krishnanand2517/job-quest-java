package com.krish.jobquestbackend;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<List<Job>>(jobService.allJobs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Job>> getSingleJob(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Job>>(jobService.singleJob(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return new ResponseEntity<Job>(jobService.createJob(job), HttpStatus.CREATED);
    }
}