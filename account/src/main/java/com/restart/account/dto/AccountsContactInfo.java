package com.restart.account.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
import java.util.List;

@ConfigurationProperties(prefix = "account")
public record AccountsContactInfo(String message, Map<String,String> contactDetails, List<String> onCallSupport) {
}
