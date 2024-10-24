package com.restart.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Documentation
@Schema(name = "NewLoan",description = "A Schema for New Loan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewLoanDto {

    //Documentation
    @Schema(description = "Mobile number of the customer",example="9999999999")
    @Pattern(regexp = "^$|[0-9]{10}")
    private String mobileNumber;

    //Documentation
    @Schema(description = "Loan type",examples={"Home Loan","Personal Loan"})
    @Positive(message="Invalid Loan Type")
    private int loanType;
}
