package com.jobmate.demo.exception;


public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Long id) {
        super("Could not find user with id " + id);
    }
}
