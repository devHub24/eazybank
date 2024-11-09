package com.restart.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Documentation
@Schema(name = "Credit Card", description = "Schema for Credit card Dto")
public class CreditCardDto {

    @Schema(description = "Card number of credit card", example = "Randomly generated 16 digit number")
    private Long cardNumber;
    @Schema(description = "Mobile number of Credit Card",example = "9999999999")
    private String mobileNumber;
    @Schema(description = "Card type of the Card",example="Credit card")
    private String cardType;
    @Schema(description = "Variant of the Card",examples = {"Platinum","Diamond"})
    private String cardVariant;
    @Schema(description = "Limit of the Credit card",example="500000")
    private double cardLimit;
    @Schema(description = "Amount used out of limit",example="30000")
    private double amountUsed;
    @Schema(description = "Amount remaining after Amount used",examples = "470000")
    private double availableAmount;
}
