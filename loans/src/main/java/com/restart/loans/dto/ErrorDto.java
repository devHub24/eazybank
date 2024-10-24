package com.restart.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//Documentation
@Schema(name = "Error",description = "A Schema for Error")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
    //Documentation
    @Schema(description = "Error path",example="uri/error")
    private String path;

    //Documentation
    @Schema(description = "Error code",example="400")
    private String code;

    //Documentation
    @Schema(description = "Error message",example="loan not found")
    private String message;

    //Documentation
    @Schema(description = "Error timeStamp",example="12:00:45")
    private LocalDateTime timeStamp;
}
