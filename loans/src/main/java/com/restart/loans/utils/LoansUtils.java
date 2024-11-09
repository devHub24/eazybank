package com.restart.loans.utils;

import com.restart.loans.entity.Loans;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import static com.restart.loans.constants.LoansConstants.*;

@Service
public class LoansUtils {

    public Long getLoanNumber(){
        Long loanNumber= 100000000000L+new Random().nextInt(900000000);
        return loanNumber;
    }

    public double getLoanAmount(int loanType){
        double loanAmount=0.0;
        switch(loanType){

            case 1:{
                loanAmount=HOME_LOAN_LIMIT;
                break;
            }

            case  2:{
                loanAmount=VEHICLE_LOAN_LIMIT;
                break;
            }

            case 3:{
                loanAmount=PERSONAL_LOAN_LIMIT;
                break;
            }

            case 4:{
                loanAmount=GOLD_LOAN_LIMIT;
                break;
            }
        }
        return loanAmount;
    }

    public String getLoanType(int num){
        String result="";
        if(num==1){
            result= HOME_LOAN;
        }

        if(num==2){
            result=VEHICLE_LOAN;
        }

        if(num==3){
            result=PERSONAL_LOAN;
        }

        if(num==4){
            result=GOLD_LOAN;
        }

        return result;
    }

    public boolean loanAlreadyExists(List<Loans> loansList,String loanType){
        boolean result=false;
        for(Loans loan:loansList){
            if(loan.getLoanType().equalsIgnoreCase(loanType)){
                result= true;
                break;
            }
        }
        return result;
    }
}
