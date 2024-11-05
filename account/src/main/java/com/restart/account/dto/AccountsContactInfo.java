package com.restart.account.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
import java.util.List;

@ConfigurationProperties(prefix = "account")
@Data
@ToString
public class AccountsContactInfo{

    private String message;
    private Map<String,String> contactDetails;
    private List<String> onCallSupport;
}
