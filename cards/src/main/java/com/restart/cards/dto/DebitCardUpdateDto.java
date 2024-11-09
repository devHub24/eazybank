package com.restart.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Documentation
@Schema(name = "Debit Card Update",description = "Update Dto to Credit Card")
public class DebitCardUpdateDto {

    //Documentation
    @Schema(description = "Number of the Card",example="Randomly generated 16 digit Number")
    @Positive(message="Card Number can't be negative or Zero")
    private Long cardNumber;

    //Documentation
    @Schema(description = "Last Transaction amount",example = "20000")
    @Positive(message= "Amount can't be negative or Zero")
    private double lastTransactionAmount;
}
