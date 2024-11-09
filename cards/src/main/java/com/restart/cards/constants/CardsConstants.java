package com.restart.cards.constants;

import java.util.HashMap;
import java.util.Map;

public class CardsConstants {

    public static final String STATUS_200="200";
    public static final String MESSAGE_200="Request Processed Successfully";
    public static final String STATUS_201="201";
    public static final String MESSAGE_201="Card Created Successfully";
    public static final String STATUS_417="417";
    public static final String MESSAGE_417_UPDATE="Update operation failed contact DEV";
    public static final String MESSAGE_417_DELETE="Delete operation failed contact DEV";
    public static final String MESSAGE_200_UPDATE="Updated the card successfully";
    public static final String MESSAGE_200_DELETE="Card Deleted successfully";

    //Cards Constants
    public static final String DEBIT_CARD="Debit Card";
    public static final double DEBIT_CARD_LIMIT=50000;
    public static final String DEBIT_CARD_VARIANT="Debit Variant";
    public static final String CREDIT_CARD="Credit Card";
    public static final String CREDIT_CARD_PLATINUM="Platinum";
    public static final String CREDIT_CARD_DIAMOND="Diamond";
    public static final double CREDIT_CARD_PLATINUM_LIMIT =1000000;
    public static final double CREDIT_CARD_DIAMOND_LIMIT=5000000;

    public static final Map<Integer,String> cardTypeMap=new HashMap<>();
    public static final Map<Integer,String> cardVariantMap=new HashMap<>();
    public static final Map<Integer,Double> cardLimitMap= new HashMap<>();
    static{
        cardTypeMap.put(1,DEBIT_CARD);
        cardTypeMap.put(2,CREDIT_CARD);
        //CardVariant Map
        cardVariantMap.put(0,DEBIT_CARD_VARIANT);
        cardVariantMap.put(1,CREDIT_CARD_PLATINUM);
        cardVariantMap.put(2,CREDIT_CARD_DIAMOND);
        //CardLimit Map
        cardLimitMap.put(1,CREDIT_CARD_PLATINUM_LIMIT);
        cardLimitMap.put(2,CREDIT_CARD_DIAMOND_LIMIT);
    }
}
