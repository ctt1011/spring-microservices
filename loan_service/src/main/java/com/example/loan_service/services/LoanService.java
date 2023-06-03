package com.example.loan_service.services;

import java.util.List;

import com.example.loan_service.entities.Loan;

public interface LoanService {
    public List<Loan> getLoansDetails(long customerId);
}
