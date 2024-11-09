package com.restart.loans.service;

import com.restart.loans.dto.LoansDto;
import com.restart.loans.dto.NewLoanDto;
import com.restart.loans.dto.UpdateLoanDto;
import com.restart.loans.entity.Loans;
import com.restart.loans.exceptions.LoansExceptions;
import com.restart.loans.mapper.LoansMapper;
import com.restart.loans.repository.ILoansRepository;
import com.restart.loans.utils.LoansUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.restart.loans.enums.LoansErrors.*;
import static com.restart.loans.constants.LoansConstants.*;

@Service
public class ImpLoansService implements ILoansService{

    @Autowired
    private ILoansRepository loansRepo;
    @Autowired
    private LoansMapper loansMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoansUtils loansUtils;

    /**
     *
     * @param newLoanDto
     * @return loanDto
     */
    @Override
    public LoansDto newLoan(NewLoanDto newLoanDto) {

       List<Loans> loansList=loansRepo.findAllByMobileNumber(newLoanDto.getMobileNumber());
       String loanType=loansUtils.getLoanType(newLoanDto.getLoanType());
       if(loansUtils.loanAlreadyExists(loansList,loanType)){
           throw new LoansExceptions(LOAN_ALREADY_EXISTS,String.format("Loan already exists for Customer with mobile no:%s " +
                   "and Loan Type:%s",newLoanDto.getMobileNumber(),loanType));
       }
        Loans loan=loansMapper.mapNewLoan(newLoanDto,new Loans());
        Loans savedLoan=loansRepo.save(loan);
        LoansDto resultDto= loansMapper.mapToDto(savedLoan,new LoansDto());
        return resultDto;
    }

    /**
     *
     * @param updateLoanDto
     * @return loansDto
     */
    @Override
    public LoansDto updateLoan(UpdateLoanDto updateLoanDto) {
        LoansDto resultDto;
           Loans loans=loansRepo.findById(updateLoanDto.getLoanNumber()).orElseThrow(()->
                   new LoansExceptions(LOAN_NOT_FOUND,
                           String.format("Loan not found with the loan number:%s",updateLoanDto.getLoanNumber())));

           loans.setAmountPaid(loans.getAmountPaid()+updateLoanDto.getAmountPaid());
           loans.setOutStandingAmount(loans.getTotalLoan()-updateLoanDto.getAmountPaid());
           Loans savedLoan=loansRepo.save(loans);
           resultDto= loansMapper.mapToDto(savedLoan,new LoansDto());
        return resultDto;
    }

    /**
     *
     * @param loanNumber
     */
    @Override
    public void deleteLoanByNumber(Long loanNumber) {
        if(loansRepo.findById(loanNumber).isEmpty()){
            throw new LoansExceptions(LOAN_NOT_FOUND,String.format("Loan not found with number:%s",loanNumber));
        }
        loansRepo.deleteById(loanNumber);
    }

    /**
     *
     * @param mobileNumber
     * @return
     */
    @Override
    public List<LoansDto> getAllByMobileNo(String mobileNumber) {
        List<Loans> loansList= loansRepo.findAllByMobileNumber(mobileNumber);
        List<LoansDto> resultList;
        if(loansList.isEmpty()){
            throw new LoansExceptions(LOAN_NOT_FOUND,LOAN_NOT_FOUND.name());
        }
        resultList=loansList.stream().map(loan->loansMapper.mapToDto(loan,new LoansDto())).toList();
        return resultList;
    }

    /**
     *
     * @param loanNumber
     * @return loansDto
     */
    @Override
    public LoansDto getByLoanNumber(Long loanNumber) {
        Loans loan=  loansRepo.findById(loanNumber).orElseThrow(()->
                new LoansExceptions(LOAN_NOT_FOUND,String.format("Loan not found for the Loan number:%s",loanNumber))
                );
        LoansDto loansDto= loansMapper.mapToDto(loan,new LoansDto());
        return loansDto;
    }

    /**
     *
     * @param loanType
     * @return resultList
     */
    @Override
    public List<LoansDto> getByLoanType(String loanType) {
        List<Loans> loansList= loansRepo.findAllByLoanType(loanType);
        if(loansList.isEmpty()){
            throw new LoansExceptions(LOAN_NOT_FOUND,LOAN_NOT_FOUND.name());
        }
        List<LoansDto>resultList= loansList.stream().map(loan->loansMapper.mapToDto(loan,new LoansDto())).toList();
        return resultList;
    }


}
