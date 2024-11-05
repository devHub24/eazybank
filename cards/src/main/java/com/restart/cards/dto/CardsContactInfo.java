package com.restart.cards.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "cards")
@Data
@ToString
public class CardsContactInfo {

    private String message;
    private Map<String,String> contactDetails;
    private List<String> onCallSupport;
}
