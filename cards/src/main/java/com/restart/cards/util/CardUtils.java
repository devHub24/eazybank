package com.restart.cards.util;

import com.restart.cards.dto.NewCardDto;
import com.restart.cards.entity.CreditCard;
import com.restart.cards.entity.DebitCard;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

import static com.restart.cards.constants.CardsConstants.*;
@Service
public class CardUtils {

    public Long getCardNumber(){
        Long result= 10000000000000000L+new Random().nextInt(900000000);
        return result;
    }

    public boolean checkCardAlreadyExists(List<CreditCard> creditCardsList, NewCardDto newCardDto){
        boolean result=false;
        for(CreditCard cards: creditCardsList){
           if( cards.getCardType().equalsIgnoreCase(cardTypeMap.get(newCardDto.getCardType()))
                   && cards.getCardVariant().equalsIgnoreCase(cardVariantMap.get(newCardDto.getCardVariant())))

           {
               result=true;
               break;
           }
        }
        return result;
    }

    public boolean checkDebitCardAlreadyExists(List<DebitCard> debitCardList, NewCardDto newCardDto){
        boolean result=false;
        for(DebitCard card:debitCardList){
             if (card.getCardType().equalsIgnoreCase(cardTypeMap.get(newCardDto.getCardType()))){
               result= true;
            }
        }
        return result;
    }
}
