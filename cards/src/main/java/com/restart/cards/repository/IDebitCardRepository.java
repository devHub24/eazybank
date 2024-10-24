package com.restart.cards.repository;

import com.restart.cards.entity.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDebitCardRepository extends JpaRepository<DebitCard,Long> {
        public List<DebitCard> findAllByMobileNumber(String mobileNumber);
}
