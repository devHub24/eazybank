package com.restart.cards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard extends Cards{

    @Id
    private Long cardNumber;
    private String cardVariant;
    private double cardLimit;
    private double amountUsed;
    private double availableAmount;
}
