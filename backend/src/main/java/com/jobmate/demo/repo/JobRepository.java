package com.jobmate.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobmate.demo.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
    
}
