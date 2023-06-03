package com.example.account_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.account_service.entities.Account;
import com.example.account_service.repositories.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccountDetails(long customerId) {
        Account account = accountRepository.findByCustomerId(customerId);
        if (account != null) {
            return account;
        } else {
            return null;
        }

    }
}
