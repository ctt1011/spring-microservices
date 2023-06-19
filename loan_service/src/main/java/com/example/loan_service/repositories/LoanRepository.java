package com.example.loan_service.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.loan_service.entities.Loan;

public interface LoanRepository extends CrudRepository<Loan, Long> {
    List<Loan> findByCustomerIdOrderByStartDateDesc(long customerId);
}
