package com.jobmate.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue
    @Column(name = "job_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "job_name")
    private String name;

    @Column(name = "job_company")
    private String company;

    @Column(name = "job_status")
    private String status;

    public Job(Account account, String name, String company, String status) {
        this.account = account;
        this.name = name;
        this.company = company;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public String getCompany() {
        return this.company;
    }

    public String getStatus() {
        return this.status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
