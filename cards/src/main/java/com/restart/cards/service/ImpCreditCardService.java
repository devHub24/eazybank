package com.restart.cards.service;

import com.restart.cards.dto.*;
import com.restart.cards.entity.CreditCard;
import com.restart.cards.entity.DebitCard;
import com.restart.cards.exceptions.CardsExceptions;
import com.restart.cards.mapper.CreditCardsMapper;
import com.restart.cards.mapper.DebitCardsMapper;
import com.restart.cards.repository.ICreditCardRepository;
import com.restart.cards.repository.IDebitCardRepository;
import com.restart.cards.util.CardUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.restart.cards.enums.CardsErrors.*;
import com.restart.cards.entity.Cards;

import java.util.List;

import static com.restart.cards.constants.CardsConstants.*;

@Service
public class ImpCreditCardService implements ICardsService{

    @Autowired
    private ICreditCardRepository creditCardRepo;
    @Autowired
    private IDebitCardRepository debitCardRepo;
    @Autowired
    private CreditCardsMapper creditCardsMapper;
    @Autowired
    private DebitCardsMapper debitCardsMapper;
    @Autowired
    private CardUtils cardUtils;

    /**
     *
     * @param newCardDto
     * @return Cards
     */
    @Override
    public Cards newCard(NewCardDto newCardDto) {
        Cards result;
        if(newCardDto.getCardType()==1){
            result=newDebitCard(newCardDto);
        }else{
            result=newCreditCard(newCardDto);
        }
        return result;
    }


    /**
     *
     * @param newCardDto
     * @return result
     */
    public CreditCard newCreditCard(NewCardDto newCardDto){
        if(cardUtils.checkCardAlreadyExists(creditCardRepo.findAllByMobileNumber(newCardDto.getMobileNumber()),newCardDto)){
            throw new CardsExceptions(CREDIT_CARD_ALREADY_EXISTS,String.format("Credit already exists for the customer"));
        }
        CreditCard newCard=creditCardsMapper.mapNewCard(newCardDto);
        CreditCard savedCard= creditCardRepo.save(newCard);
        return savedCard;
    }

    /**
     *
     * @param newCardDto
     * @return DebitCard
     */
    public DebitCard newDebitCard(NewCardDto newCardDto){
        if(cardUtils.checkDebitCardAlreadyExists(debitCardRepo.findAllByMobileNumber(newCardDto.getMobileNumber()),newCardDto)){
            throw new CardsExceptions(DEBIT_CARD_ALREADY_EXISTS,"Debit Card Already Exists for the customer");
        }
        DebitCard newCard=debitCardsMapper.mapNewCard(newCardDto,new DebitCard());
        DebitCard savedCard=debitCardRepo.save(newCard);
        return savedCard;
    }

    /**
     *
     * @param creditCardDto
     * @return
     */
    @Override
    public CreditCardDto updateCard(CreditCardUpdateDto creditCardDto) {
        CreditCard card= creditCardRepo.findById(creditCardDto.getCardNumber()).orElseThrow(()->
                    new CardsExceptions(CREDIT_CARD_NOT_FOUND,
                            String.format("Credit card not found with the card number:%s", creditCardDto.getCardNumber()))
        );
        if(creditCardDto.getCardVariant()!=0){
            card.setCardVariant(cardVariantMap.get(creditCardDto.getCardVariant()));
        }
        card.setAmountUsed(creditCardDto.getAmountUsed());
        card.setAvailableAmount(card.getAvailableAmount()-creditCardDto.getAmountUsed());
        CreditCard savedCard=creditCardRepo.save(card);
        CreditCardDto result= creditCardsMapper.mapToCreditDto(savedCard,new CreditCardDto());
        return result;
    }

    /**
     *
     * @param debitCardUpdateDto
     * @return
     */
    @Override
    public DebitCardDto updateCard(DebitCardUpdateDto debitCardUpdateDto) {
        DebitCard card=debitCardRepo.findById(debitCardUpdateDto.getCardNumber()).orElseThrow(()->
                new CardsExceptions(DEBIT_CARD_NOT_FOUND,
                        String.format("Debit Card not found with card number:%s",debitCardUpdateDto.getCardNumber()))
                );

        card.setLastTransactionAmount(debitCardUpdateDto.getLastTransactionAmount());
        card.setCurrentBalance(card.getCurrentBalance()-debitCardUpdateDto.getLastTransactionAmount());
        DebitCard savedCard= debitCardRepo.save(card);
        DebitCardDto result= debitCardsMapper.mapToDebitDto(savedCard,new DebitCardDto());
        return result;
    }

    /**
     *
     * @param mobileNumber
     * @return resultList
     *//*
    @Override
    public List<DebitCardDto> getAllDebitByMobileNumber(String mobileNumber) {
        List<DebitCard> debitList= debitCardRepo.findAllByMobileNumber(mobileNumber);
        List<DebitCardDto> resultList= debitList
                .stream()
                .map(debit->
                        debitCardsMapper.mapToDebitDto(debit,new DebitCardDto()))
                .toList();
        return resultList;
    }*/

    /**
     *
     * @param mobileNumber
     * @return resultList
     */
    @Override
    public List<CreditCardDto> getAllCreditByMobileNumber(String mobileNumber) {
        List<CreditCard> creditList= creditCardRepo.findAllByMobileNumber(mobileNumber);
        List<CreditCardDto> resultList= creditList
                .stream()
                .map(credit->
                        creditCardsMapper.mapToCreditDto(credit,new CreditCardDto()))
                .toList();
        return resultList;
    }

    /**
     *
     * @param cardNumber
     * @return result
     */
    @Override
    public DebitCardDto getDebitByCardNumber(Long cardNumber) {
        DebitCard card=debitCardRepo.findById(cardNumber).orElseThrow(()->
                new CardsExceptions(DEBIT_CARD_NOT_FOUND,
                        String.format("Debit Card not found with card Number:%s",cardNumber))
                );
        DebitCardDto result=debitCardsMapper.mapToDebitDto(card,new DebitCardDto());
        return result;
    }

    /**
     *
     * @param cardNumber
     * @return result
     */
    @Override
    public CreditCardDto getCreditByCardNumber(Long cardNumber) {
        CreditCard card= creditCardRepo.findById(cardNumber).orElseThrow(()->
                new CardsExceptions(CREDIT_CARD_NOT_FOUND,String.format("Card not found with card number:%s",cardNumber))
                );

        CreditCardDto result= creditCardsMapper.mapToCreditDto(card,new CreditCardDto());
        return result;
    }

    /**
     *
     * @param cardNumber
     */
    @Override
    public void deleteCard(Long cardNumber,int cardType) {
        if (cardType == 1) {
            debitCardRepo.deleteById(cardNumber);
        } else {
            creditCardRepo.deleteById(cardNumber);
        }
    }

}
