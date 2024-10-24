package com.restart.cards.exceptions;

import com.restart.cards.enums.CardsErrors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CardsExceptions extends RuntimeException {

    private CardsErrors errors;
    private String message;
    public CardsExceptions(CardsErrors errors,String message) {

        super(message);
        this.errors=errors;
        this.message=message;
    }
}
