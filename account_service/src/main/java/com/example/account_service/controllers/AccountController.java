package com.example.account_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.account_service.entities.Account;
import com.example.account_service.services.AccountService;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/customers/{customerId}")
    public Account getAccountDetails(@PathVariable long customerId) {
        return accountService.getAccountDetails(customerId);
    }
}
