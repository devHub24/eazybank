package com.restart.cards.service;

import com.restart.cards.dto.*;
import com.restart.cards.entity.Cards;

import javax.smartcardio.Card;
import java.util.List;

public interface ICardsService {

    public Cards newCard(NewCardDto newCardDto);
    public CreditCardDto updateCard(CreditCardUpdateDto creditCardDto);
    public DebitCardDto updateCard(DebitCardUpdateDto debitCardUpdateDto);
    //public List<DebitCardDto> getAllDebitByMobileNumber(String mobileNumber);
    public List<CreditCardDto> getAllCreditByMobileNumber(String mobileNumber);
    public DebitCardDto getDebitByCardNumber(Long cardNumber);
    public CreditCardDto getCreditByCardNumber(Long cardNumber);
    public void deleteCard(Long cardNumber,int cardType);

}
