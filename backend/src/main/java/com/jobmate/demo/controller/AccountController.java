package com.jobmate.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobmate.demo.entity.Job;
import com.jobmate.demo.entity.Account;
import com.jobmate.demo.service.AccountService;

@RestController
public class AccountController {
    private final AccountService serve;

    public AccountController(AccountService serve) {
        this.serve = serve;
    }

    @GetMapping("/account/all") 
    public List<Account> all() {
        return this.serve.all();
    }

    @PostMapping("/account/new")
    public Account newAccount(@RequestBody Account newAccount) {
        return serve.newAccount(newAccount);
    }

    @GetMapping("/account/search")
    public Account one(@RequestParam(value = "id", required = true) Long id) {
        return serve.one(id);
    }

    @PostMapping("/account/update")
    public Account change(@RequestBody Account newAccount, @RequestParam(value = "id", required = true) Long id) {
        return serve.change(id, newAccount);
    }

    @GetMapping("/account/{id}/jobs")
    public List<Job> getJobs(@PathVariable Long id) {
        return serve.getJobs(id);
    }

    @PostMapping("account/{id}/new/job")
    public Account addJob(@PathVariable Long id,
    @RequestParam(value = "name") String name,
    @RequestParam(value = "company") String company,
    @RequestParam(value = "status") String status) {
        return serve.addJob(id, name, company, status);
    }

    @DeleteMapping("/account/job/{id}")
    public void deleteJob(@PathVariable Long id) {
        serve.deleteJob(id);
    }

    @DeleteMapping("/account/delete")
    public void delete(@RequestParam(required = true) Long id) {
        serve.delete(id);
    }
}
