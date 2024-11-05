package com.restart.loans.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "loans")
@Data
@ToString
public class LoansContactInfo {

    private String message;
    private Map<String,String> contactDetails;
    private List<String> onCallSupport;
}
