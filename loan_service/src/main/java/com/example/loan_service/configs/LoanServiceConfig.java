package com.example.loan_service.configs;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "loan-service")
@Data
public class LoanServiceConfig {

  private String msg;
  private String buildVersion;
  private Map<String, String> mailDetails;
  private List<String> activeBranches;
}
