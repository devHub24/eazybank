package com.restart.loans.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Loans extends BaseEntity{

    @Id
    private Long loanNumber;
    private String mobileNumber;
    private String loanType;
    private double totalLoan;
    private double amountPaid;
    private double outStandingAmount;
}
