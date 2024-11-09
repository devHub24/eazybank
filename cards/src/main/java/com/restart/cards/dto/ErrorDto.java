package com.restart.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Documentation
@Schema(name = "Error",description = "Schema for Error")
public class ErrorDto {

    //Documentation
    @Schema(description = "Path of the error",example="uri/api/newapi")
    private String path;

    //Documentation
    @Schema(description = "Code of the Error",example="CARD_NOT_FOUND")
    private String code;

    //Documentation
    @Schema(description = "Error Message",example="Card not found for the customer")
    private String message;

    //Documentation
    @Schema(description = "Time of the error",example="18:00:00")
    private LocalDateTime timeStamp;
}
