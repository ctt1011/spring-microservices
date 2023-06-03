package com.example.loan_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loan_service.entities.Loan;
import com.example.loan_service.services.LoanService;

@RestController
@RequestMapping("api/v1/loans/")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/customers/{customerId}")
    public List<Loan> getLoansDetails(@PathVariable long customerId) {
        return loanService.getLoansDetails(customerId);
    }
}
