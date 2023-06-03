package com.example.account_service.services;

import com.example.account_service.entities.Account;

public interface AccountService {
    public Account getAccountDetails(long customerId);
}
