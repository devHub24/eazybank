package com.restart.loans.repository;

import com.restart.loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILoansRepository extends JpaRepository<Loans,Long> {

    public List<Loans> findAllByMobileNumber(String mobileNumber);
    public List<Loans> findAllByLoanType(String loanType);
}
