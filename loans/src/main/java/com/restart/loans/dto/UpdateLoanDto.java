package com.restart.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Documentation
@Schema(name="UpdateLoan", description="A Schema to update Loan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLoanDto {

    //Documentation
    @Schema(description = "Loan number",example="Randomly generated 12 digit number")
    @Positive(message="Loan number can't be negative or zero")
    private Long loanNumber;

    //Documentation
    @Schema(description = "Amount paid by the customer",example="20000")
    @Positive(message="Amount paid can't be negative or Zero")
    private double amountPaid;
}
