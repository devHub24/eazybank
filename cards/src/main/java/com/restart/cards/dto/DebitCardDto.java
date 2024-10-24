package com.restart.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Documentation
@Schema(name = "Debit Card",description = "Schema for Debit Card")
public class DebitCardDto {
    //Documentation
    @Schema(description = "Mobile number of the customer",example="99999999999")
    private String mobileNumber;

    //Documentation
    @Schema(description = "Card Number",example="Randomly generated 16 digit number")
    private Long cardNumber;

    //Documentation
    @Schema(description = "Type of the Card",example="Debit")
    private String cardType;

    //Documentation
    @Schema(description = "Current Balance in the amount",example="5000")
    private double currentBalance;

    //Documentation
    @Schema(description = "Last Transaction amount",example="4000")
    private double lastTransactionAmount;
}
