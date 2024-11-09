package com.restart.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Documentation
@Schema(name = "New Card",description = "Schema for New Card")
public class NewCardDto {

    //Documentation
    @Schema(description = "Mobile number of the customer",example="9999999999")
    @NotEmpty(message="Mobile number can't be empty")
    @Pattern(regexp = "^$|[0-9]{10}")
    private String mobileNumber;

    //Documentation
    @Schema(description = "Type of the card",examples={"1","2"})
    @Positive(message = "Card type can't be negative or zero")
    private int cardType;

    //Documentation
    @Schema(description = "Variant of the Card",examples={"0","1","2"})
    @PositiveOrZero(message = "Card variant can't be negative")
    private int cardVariant;
}
