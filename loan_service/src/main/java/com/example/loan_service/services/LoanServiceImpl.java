package com.example.loan_service.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan_service.entities.Loan;
import com.example.loan_service.repositories.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public List<Loan> getLoansDetails(long customerId) {
        List<Loan> loans = loanRepository.findByCustomerIdOrderByStartDateDesc(customerId);
        if (loans != null) {
            return loans;
        } else {
            return Collections.emptyList();
        }
    }

}
