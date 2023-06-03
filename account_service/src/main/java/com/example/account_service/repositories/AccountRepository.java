package com.example.account_service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.account_service.entities.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByCustomerId(long customerId);
}
