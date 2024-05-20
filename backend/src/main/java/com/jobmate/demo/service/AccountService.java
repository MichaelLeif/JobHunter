package com.jobmate.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobmate.demo.entity.Job;
import com.jobmate.demo.entity.Account;
import com.jobmate.demo.exception.AccountNotFoundException;
import com.jobmate.demo.factory.JobFactory;
import com.jobmate.demo.repo.AccountRepository;
import com.jobmate.demo.repo.JobRepository;

@Service
public class AccountService {
    @Autowired
    private final AccountRepository aRepo;

    @Autowired
    private final JobRepository jRepo;

    public AccountService(AccountRepository aRepo, JobRepository jRepo) {
        this.aRepo = aRepo;
        this.jRepo = jRepo;
    }

    public List<Account> all() {
        return aRepo.findAll();
    }

    public Account newAccount(Account newAccount) {
        return aRepo.save(newAccount);
    }

    public Account one(Long id) {
        return aRepo.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
    }

    public Account change(Long id, Account update) {
        return aRepo.findById(id).map(account -> {
            account.setName(update.getName());
            account.setEmail(update.getEmail());
            account.setPassword(update.getPassword());
            return aRepo.save(account);
        })
        .orElseThrow(() -> new AccountNotFoundException(id));
    }

    public List<Job> getJobs(Long id) {
        return aRepo.findById(id).map(account -> account.getJobs()).orElseThrow(() -> new AccountNotFoundException(id));
    }

    public Account addJob(Long id, String name, String company, String status) {
        JobFactory create = new JobFactory();
        return aRepo.findById(id).map(account -> {
            Job newJob = create.createJob(account, name, company, status);
            account.addJob(jRepo.save(newJob));
            return aRepo.save(account);
        })
        .orElseThrow(() -> new AccountNotFoundException(id));
    }

    public void deleteJob(Long id) {
        jRepo.deleteById(id);
    }

    public void delete(Long id) {
        aRepo.deleteById(id);
    }
}
