package com.restart.cards.controller;

import com.restart.cards.dto.*;
import com.restart.cards.entity.Cards;
import com.restart.cards.service.ICardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static  com.restart.cards.constants.CardsConstants.*;

//Documentation
@Tag(name = "Cards REST API",description = "REST API for Cards_MS")
@RestController
@RequestMapping(value = "/cards/v1",produces = MediaType.APPLICATION_JSON_VALUE)
public class CardsController {

    @Autowired
    private ICardsService cardsService;

    //Documentation
    @Operation(summary = "ADD Card API",description = "REST API to add a new Card")
    @ApiResponses({
            @ApiResponse(responseCode = STATUS_201, description = MESSAGE_200,
                    content =@Content(schema=@Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = STATUS_417, description = "Failed to create a Card",
                    content =@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @PostMapping("/newCard")
    public ResponseEntity newCard(@RequestBody NewCardDto newCardDto){
        cardsService.newCard(newCardDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_201,MESSAGE_201));
    }

    //Documentation
    @Operation(summary = "Update Debit Card API",description = "REST API to update a debit card")
    @ApiResponses({
            @ApiResponse(responseCode = STATUS_200,description = MESSAGE_200_UPDATE,
                    content =@Content(schema=@Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = STATUS_417,description = MESSAGE_417_UPDATE,
                    content =@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @PutMapping("/updateDebitCard")
    public ResponseEntity updateDebitCard(@Valid @RequestBody DebitCardUpdateDto debitCardUpdateDto){
        cardsService.updateCard(debitCardUpdateDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_200,MESSAGE_200_UPDATE));
    }

    //Documentation
    @Operation(summary = "Update Credit Card API",description = "REST API to update a credit card")
    @ApiResponses({
            @ApiResponse(responseCode = STATUS_200,description = MESSAGE_200_UPDATE,
                    content =@Content(schema=@Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = STATUS_417,description = MESSAGE_417_UPDATE,
                    content =@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @PutMapping("/updateCreditCard")
    public ResponseEntity updateCreditCard(@Valid @RequestBody CreditCardUpdateDto creditCardUpdateDto){
        cardsService.updateCard(creditCardUpdateDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_200,MESSAGE_200_UPDATE));
    }

    //Documentation
    @Operation(summary = "Fetch CreditCards API", description = "REST API to fetch credit card details by mobile number")
    @ApiResponses({
            @ApiResponse(responseCode = STATUS_200,description = MESSAGE_200,
            content=@Content(schema=@Schema(implementation = CreditCardDto.class))),
            @ApiResponse(responseCode = "400",description = "Bad Request",
                    content =@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @GetMapping("/getAllCreditsByMobile")
    public ResponseEntity getCreditsByMobile(@Valid @Pattern(regexp = "^$|[0-9]{10}") @RequestParam String mobileNumber){
        List<CreditCardDto> result= cardsService.getAllCreditByMobileNumber(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    //Documentation
    @Operation(summary = "Fetch DebitCards API", description = "REST API to fetch Debit card details by Card number")
    @ApiResponses({
            @ApiResponse(responseCode = STATUS_200,description = MESSAGE_200,
                    content=@Content(schema=@Schema(implementation = DebitCardDto.class))),
            @ApiResponse(responseCode = "400",description = "Bad Request",
                    content =@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @GetMapping("/getDebitByNumber")
    public ResponseEntity getDebitCardByNumber(@Valid @Positive(message="Card Number can't be negative or zero")
                                                   @RequestParam Long cardNumber){
        DebitCardDto result= cardsService.getDebitByCardNumber(cardNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    //Documentation
    @Operation(summary = "Fetch CreditCards API", description = "REST API to fetch credit card details by Card number")
    @ApiResponses({
            @ApiResponse(responseCode = STATUS_200,description = MESSAGE_200,
                    content=@Content(schema=@Schema(implementation = CreditCardDto.class))),
            @ApiResponse(responseCode = "400",description = "Bad Request",
                    content =@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @GetMapping("/getCreditCardByNumber")
    public ResponseEntity getCreditCardByNumber(@Valid @Positive(message="Card Number can't be negative or zero")
                                                    @RequestParam Long cardNumber){
        CreditCardDto result= cardsService.getCreditByCardNumber(cardNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    //Documentation
    @Operation(summary = "Delete debit cards API", description = "REST API to delete debit card details by card number")
    @ApiResponses({
            @ApiResponse(responseCode = STATUS_200,description = MESSAGE_200,
                    content=@Content(schema=@Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "400",description = "Bad Request",
                    content =@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @DeleteMapping("/deleteDebit")
    public ResponseEntity deleteDebitCard(@Valid @Positive(message="Card Number can't be negative or zero")
                                              @RequestParam Long cardNumber,
                                          @Valid @Positive(message = "Card type cant' be zero or negative")
                                          @RequestParam int cardType){
        cardsService.deleteCard(cardNumber,cardType);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_200,MESSAGE_200_DELETE));
    }

}
