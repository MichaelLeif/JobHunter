package com.jobmate.demo.factory;

import com.jobmate.demo.entity.Job;

import org.springframework.stereotype.Component;

import com.jobmate.demo.entity.Account;

@Component
public class JobFactory {

    public Job createJob(Account account, String name, String company, String status) {
        Job newJob = new Job(account, name, company, status);
        return newJob;
    }
}
