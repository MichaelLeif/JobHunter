package com.jobmate.demo.entity;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "account")
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @Column(name = "account_name")
    private String name;

    @Column(name = "account_email")
    private String email;

    @Column(name = "account_password")
    private String password;
    
    @OneToMany(mappedBy = "account", orphanRemoval = true)
    private List<Job> jobs;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Job> getJobs() {
        return this.jobs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addJob(Job job) {
        this.jobs.add(job);
    }

    public void deleteJob(Long id) {
        this.jobs
        .stream()
        .filter(j -> j.getId() != id)
        .collect(Collectors.toList());
    }
}
