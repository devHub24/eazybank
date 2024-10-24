package com.restart.loans.exceptions;

import com.restart.loans.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import static com.restart.loans.constants.LoansConstants.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private String path="";
    private String message="";
    private String code="";
    private HttpStatus status=HttpStatus.OK;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentException(MethodArgumentNotValidException ex){
        List<FieldError> fieldErrors=ex.getBindingResult().getFieldErrors();

        Map<String,String> resultError= new HashMap<>();

        for(FieldError err:fieldErrors){
            resultError.put(err.getField(),err.getDefaultMessage());
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resultError);
    }

    @ExceptionHandler(LoansExceptions.class)
    public ResponseEntity<ErrorDto> handleOtherExceptions(LoansExceptions ex, WebRequest request){

        switch(ex.getError().name()){

            case "LOAN_NOT_FOUND":{
                path=request.getDescription(false);
                message=ex.getMessage();
                status=HttpStatus.NOT_FOUND;
                code=STATUS_417;
                break;
            }

            case "LOAN_ALREADY_EXISTS":{
                path=request.getDescription(false);
                message=ex.getMessage();
                status=HttpStatus.BAD_REQUEST;
                code=STATUS_417;
                break;
            }

            case "GENERAL_EXCEPTION":{
                path= request.getDescription(false);
                message=ex.getMessage();
                status=HttpStatus.NOT_FOUND;
                code=STATUS_417;
                break;
            }
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(path,code,message, LocalDateTime.now()));
    }

}
