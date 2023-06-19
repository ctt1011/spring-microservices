package com.example.account_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.account_service.configs.AccountServiceConfig;
import com.example.account_service.entities.Account;
import com.example.account_service.entities.Property;
import com.example.account_service.services.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping("/api/v1/accounts")

public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountServiceConfig accountServiceConfig;

    @GetMapping("/customers/{customerId}")
    public Account getAccountDetails(@PathVariable long customerId) {
        return accountService.getAccountDetails(customerId);
    }

    @GetMapping("/properties")
    public String getProperties() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Property property = Property.builder()
                .msg(accountServiceConfig.getMsg())
                .buildVersion(accountServiceConfig.getBuildVersion())
                .mailDetails(accountServiceConfig.getMailDetails())
                .activeBranches(accountServiceConfig.getActiveBranches())
                .build();
        return objectWriter.writeValueAsString(property);
    }

}
