package com.restart.loans.constants;

public class LoansConstants {

    //status and Codes
    public static final String STATUS_200="200";
    public static final String MESSAGE_200="Request Processed Successfully";
    public static final String MESSAGE_200_UPDATE="Loan Updated Successfully";
    public static final String MESSAGE_200_DELETE="Loan deleted successfully";
    public static final String STATUS_201="201";
    public static final String MESSAGE_201="Loan Created Successfully";
    public static final String STATUS_302="302";
    public static final String MESSAGE_302="Loan Found Successfully";
    public static final String STATUS_400="400";
    public static final String MESSAGE_400="Bad Request";
    public static final String STATUS_417="417";
    public static final String MESSAGE_UPDATE_FAIL="Update operation has failed contact DEV";
    public static final String MESSAGE_DELETE_FAIL="Delete Operation has failed contact Dev";

    //Loan Constants
    public static final String HOME_LOAN="Home Loan";
    public static final String VEHICLE_LOAN="Vehicle Loan";
    public static final String PERSONAL_LOAN="Personal Loan";
    public static final String GOLD_LOAN="Gold Loan";

    public static final double HOME_LOAN_LIMIT=50_000_000;
    public static final double VEHICLE_LOAN_LIMIT=50_00_000;
    public static final double PERSONAL_LOAN_LIMIT=30_000_0;
    public static final double GOLD_LOAN_LIMIT=10_00_00_0;


}
