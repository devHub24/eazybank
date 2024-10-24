package com.restart.cards.repository;

import com.restart.cards.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICreditCardRepository extends JpaRepository<CreditCard,Long> {

    public List<CreditCard> findAllByMobileNumber(String mobileNumber);
    public void deleteByCardNumberAndCardVariant(Long cardNumber, String cardVariant);
}
