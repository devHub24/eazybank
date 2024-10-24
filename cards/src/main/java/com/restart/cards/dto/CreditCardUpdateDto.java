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
@Schema(name = "Credit Card Update",description = "Update Dto to Credit Card")
public class CreditCardUpdateDto {

    //Documentation
    @Schema(description = "Number of the Card",example="Randomly generated 16 digit Number")
    @Positive(message="Card Number can't be zero or negative")
    private Long cardNumber;

    //Documentation
    @Schema(description = "Variant of the card",examples={"1","2"})
    @PositiveOrZero(message="Card Variant can't be negative")
    private int cardVariant;

    //Documentation
    @Schema(description = "Amount used in the card",example = "20000")
    @PositiveOrZero(message="Amount used Can't be negative")
    private double amountUsed;
}
