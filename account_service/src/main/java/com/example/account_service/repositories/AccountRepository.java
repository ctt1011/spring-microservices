package com.example.account_service.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.account_service.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByCustomerId(long customerId);
}
