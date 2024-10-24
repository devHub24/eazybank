package com.restart.loans.service;

import com.restart.loans.dto.LoansDto;
import com.restart.loans.dto.NewLoanDto;
import com.restart.loans.dto.UpdateLoanDto;

import java.util.List;

public interface ILoansService {

    public LoansDto newLoan(NewLoanDto newLoanDto);
    public LoansDto updateLoan(UpdateLoanDto updateLoanDto);
    public void deleteLoanByNumber(Long loanNumber);
    public List<LoansDto> getAllByMobileNo(String mobileNumber);
    public LoansDto getByLoanNumber(Long loanNumber);
    public List<LoansDto> getByLoanType(String loanType);

}
