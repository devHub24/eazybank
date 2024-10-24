package com.restart.cards.mapper;

import com.restart.cards.dto.CreditCardDto;
import com.restart.cards.dto.NewCardDto;
import com.restart.cards.entity.CreditCard;
import com.restart.cards.util.CardUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.restart.cards.constants.CardsConstants.*;
@Service
public class CreditCardsMapper {

    @Autowired
    private CardUtils cardUtils;

    public CreditCard mapToCreditCard(CreditCardDto creditDto, CreditCard creditCard){
        creditCard.setMobileNumber(creditDto.getMobileNumber());
        creditCard.setCardNumber(creditDto.getCardNumber());
        creditCard.setCardVariant(creditDto.getCardVariant());
        creditCard.setCardType(creditDto.getCardType());
        creditCard.setAmountUsed(creditDto.getAmountUsed());
        creditCard.setAvailableAmount(creditCard.getAvailableAmount());
        creditCard.setCardLimit(creditDto.getCardLimit());
        return creditCard;
    }

    public CreditCardDto mapToCreditDto(CreditCard credit,CreditCardDto creditDto){

        creditDto.setMobileNumber(credit.getMobileNumber());
        creditDto.setCardType(credit.getCardType());
        creditDto.setCardVariant(credit.getCardVariant());
        creditDto.setCardNumber(credit.getCardNumber());
        creditDto.setAmountUsed(credit.getAmountUsed());
        creditDto.setAvailableAmount(credit.getAvailableAmount());
        creditDto.setCardLimit(credit.getCardLimit());
        return creditDto;
    }

    public CreditCard mapNewCard(NewCardDto newCardDto){
        CreditCard card= new CreditCard();

        card.setMobileNumber(newCardDto.getMobileNumber());
        card.setCardType(cardTypeMap.get(newCardDto.getCardType()));
        card.setCardVariant(cardVariantMap.get(newCardDto.getCardVariant()));
        card.setCardLimit(cardLimitMap.get(newCardDto.getCardVariant()));
        card.setAvailableAmount(card.getCardLimit());
        card.setAmountUsed(0);
        card.setCardNumber(cardUtils.getCardNumber());
        return card;
    }

}
