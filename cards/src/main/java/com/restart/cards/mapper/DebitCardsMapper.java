package com.restart.cards.mapper;

import com.restart.cards.dto.DebitCardDto;
import com.restart.cards.dto.NewCardDto;
import com.restart.cards.entity.DebitCard;
import com.restart.cards.util.CardUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.restart.cards.constants.CardsConstants.*;

@Service
public class DebitCardsMapper {

    @Autowired
    private CardUtils cardUtils;


    public DebitCard mapToDebitCard(DebitCardDto debitDto,DebitCard debit){

        debit.setMobileNumber(debitDto.getMobileNumber());
        debit.setCardNumber(debitDto.getCardNumber());
        debit.setCardType(debitDto.getCardType());
        debit.setCurrentBalance(debitDto.getCurrentBalance());
        debit.setLastTransactionAmount(debitDto.getLastTransactionAmount());
        return debit;
    }

    public DebitCardDto mapToDebitDto(DebitCard debit,DebitCardDto debitDto){
        debitDto.setMobileNumber(debit.getMobileNumber());
        debitDto.setCardNumber(debit.getCardNumber());
        debitDto.setCardType(debit.getCardType());
        debitDto.setCurrentBalance(debit.getCurrentBalance());
        debitDto.setLastTransactionAmount(debit.getLastTransactionAmount());

        return debitDto;
    }

    public DebitCard mapNewCard(NewCardDto newCardDto,DebitCard debitCard){
        //DebitCard debitCard= new DebitCard();

        debitCard.setMobileNumber(newCardDto.getMobileNumber());
        debitCard.setCardType(cardTypeMap.get(newCardDto.getCardType()));
        debitCard.setCardNumber(cardUtils.getCardNumber());
        debitCard.setCurrentBalance(DEBIT_CARD_LIMIT);
        debitCard.setLastTransactionAmount(0);

        return debitCard;
    }
}
