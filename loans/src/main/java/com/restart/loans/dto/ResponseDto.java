package com.restart.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Documentation
@Schema(name="Response",description = "A Schema for Response")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    //Documentation
    @Schema(description = "Response Code",example = "400")
    private String code;

    //Documentation
    @Schema(description="Response Message",example="Loan added successfully")
    private String message;
}
