package com.restart.loans.exceptions;

import com.restart.loans.enums.LoansErrors;
import lombok.Data;

@Data
public class LoansExceptions extends RuntimeException{

    private LoansErrors error;
    private String message;

    public LoansExceptions(LoansErrors error,String message){
        this.error=error;
        this.message=message;
    }
}
