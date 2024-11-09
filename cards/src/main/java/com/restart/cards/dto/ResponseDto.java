package com.restart.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Documentation
@Schema(name="Response",description = "Schema for Response")
public class ResponseDto {

    //Documentation
    @Schema(description = "Code of the Response",examples={"200","201"})
    private String code;

    //Documentation
    @Schema(description = "Response Message",examples={"Request Processed Successfully","Card Updated Successfully"})
    private String message;
}
