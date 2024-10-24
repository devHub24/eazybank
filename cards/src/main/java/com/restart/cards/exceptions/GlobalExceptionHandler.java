package com.restart.cards.exceptions;

import com.restart.cards.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.restart.cards.constants.CardsConstants.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private String path="";
    private String code="";
    private String message="";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentErrors(MethodArgumentNotValidException ex){
        List<FieldError> errors= ex.getFieldErrors();

        Map<String,String> resultErrors= new HashMap<>();

        for(FieldError error:errors){
            resultErrors.put(error.getField(),error.getDefaultMessage());
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resultErrors);
    }

    @ExceptionHandler(CardsExceptions.class)
    public ResponseEntity handleCardExceptions(CardsExceptions ex, WebRequest request){
        switch(ex.getErrors().name()){

            case "DEBIT_CARD_ALREADY_EXISTS":{
                path= request.getDescription(false);
                code=STATUS_417;
                message=ex.getMessage();
                break;
            }

            case "CREDIT_CARD_ALREADY_EXISTS":{
                path= request.getDescription(false);
                code=STATUS_417;
                message=ex.getMessage();
                break;
            }

            case "DEBIT_CARD_NOT_FOUND":{
                path= request.getDescription(false);
                code=STATUS_417;
                message=ex.getMessage();
                break;
            }

            case "CREDIT_CARD_NOT_FOUND":{
                path= request.getDescription(false);
                code=STATUS_417;
                message=ex.getMessage();
                break;
            }

            case "INSUFFICIENT_BALANCE":{
                path= request.getDescription(false);
                code=STATUS_417;
                message=ex.getMessage();
                break;
            }
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(path,code,message, LocalDateTime.now()));
    }
}
