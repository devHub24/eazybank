package com.restart.loans.mapper;

import com.restart.loans.dto.LoansDto;
import com.restart.loans.dto.NewLoanDto;
import com.restart.loans.entity.Loans;
import com.restart.loans.utils.LoansUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoansMapper {

    @Autowired
    private LoansUtils loansUtils;

    public LoansDto mapToDto(Loans loans, LoansDto loansDto){
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutStandingAmount(loans.getOutStandingAmount());
        return loansDto;
    }

    public Loans mapToLoans(LoansDto loansDto, Loans loans){
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutStandingAmount(loansDto.getOutStandingAmount());
        return loans;
    }

    public Loans mapNewLoan(NewLoanDto newLoanDto,Loans loans){
        loans.setMobileNumber(newLoanDto.getMobileNumber());
        loans.setLoanNumber(loansUtils.getLoanNumber());
        loans.setLoanType(loansUtils.getLoanType(newLoanDto.getLoanType()));
        loans.setTotalLoan(loansUtils.getLoanAmount(newLoanDto.getLoanType()));
        loans.setAmountPaid(0);
        loans.setOutStandingAmount(0);
        return loans;
    }
}
