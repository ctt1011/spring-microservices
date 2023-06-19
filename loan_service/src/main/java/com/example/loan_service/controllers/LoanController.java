package com.example.loan_service.controllers;

import com.example.loan_service.configs.LoanServiceConfig;
import com.example.loan_service.entities.Loan;
import com.example.loan_service.entities.Property;
import com.example.loan_service.services.LoanService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/loans/")
public class LoanController {

  @Autowired
  private LoanService loanService;

  @Autowired
  private LoanServiceConfig loanServiceConfig;

  @GetMapping("/customers/{customerId}")
  public List<Loan> getLoansDetails(@PathVariable long customerId) {
    return loanService.getLoansDetails(customerId);
  }

  @GetMapping("/properties")
  public String getProperties() throws JsonProcessingException {
    ObjectWriter objectWriter = new ObjectMapper()
      .writer()
      .withDefaultPrettyPrinter();
    Property property = Property
      .builder()
      .msg(loanServiceConfig.getMsg())
      .buildVersion(loanServiceConfig.getBuildVersion())
      .mailDetails(loanServiceConfig.getMailDetails())
      .activeBranches(loanServiceConfig.getActiveBranches())
      .build();
    return objectWriter.writeValueAsString(property);
  }
}
