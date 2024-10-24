package com.restart.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Documentation
@Schema(name="Loans",description = "A Schema for Loan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoansDto {

    //Documentation
    @Schema(description = "Loan number",example = "Randomly generated 12 digit number")
    private Long loanNumber;

    //Documentation
    @Schema(description = "Mobile number of the customer",example="9999999999")
    @NotEmpty(message = "Mobile Number can't be empty")
    @Pattern(regexp = "^$|[0-9]{10}")
    private String mobileNumber;

    //Documentation
    @Schema(description = "Type of the Loan",examples = {"Home Loan","Personal Loan"})
    @NotEmpty(message = "Loan type can't be empty")
    private String loanType;

    //Documentation
    @Schema(description = "Total Amount of the Loan",example="5000000")
    @Positive(message = "Loan amount cant be negative or zero")
    private double totalLoan;

    //Documentation
    @Schema(description = "Amount paid for the loan",example="2000")
    @PositiveOrZero(message = "Amount paid can't be negative")
    private double amountPaid;

    //Documentation
    @Schema(description = "Remaining OutStanding amount",example="480000")
    @PositiveOrZero(message = "OutStanding  amount can't be negative")
    private double outStandingAmount;
}
