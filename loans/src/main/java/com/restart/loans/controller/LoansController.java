package com.restart.loans.controller;

import com.restart.loans.dto.*;
import com.restart.loans.service.ILoansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.restart.loans.constants.LoansConstants.*;

@RestController
@RequestMapping(value="/loans/v1",produces = {MediaType.APPLICATION_JSON_VALUE})

//Documents
@Tag(name = "Loans API", description = "A REST API for Loans MS")
public class LoansController {
    @Autowired
    private ILoansService loansService;

    //Documentation
    @Operation(summary = "Create REST API", description = "REST API to Add new Loan", method = "POST")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Loan Created Successfully"),
            @ApiResponse(responseCode = "417", description = "Loan already exists",
                    content=@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @PostMapping("/newLoan")
    public ResponseEntity<ResponseDto> newLoan(@Valid @RequestBody NewLoanDto loansDto){
        LoansDto result= loansService.newLoan(loansDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(STATUS_201,MESSAGE_201));
    }

    //Documentation
    @Operation(summary = "Update REST API", description = "REST API to update loan")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Loan Updated Successfully"),
            @ApiResponse(responseCode = "417", description = "Loan not Found",
                    content=@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @PutMapping("/updateLoan")
    public ResponseEntity<ResponseDto> updateLoan(@Valid @RequestBody UpdateLoanDto updateLoanDto){
        loansService.updateLoan(updateLoanDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_200,MESSAGE_200_UPDATE));
    }

    //Documentation
    @Operation(summary = "DELETE REST API", description = "REST API to delete a loan")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Loan Deleted successfully"),
            @ApiResponse(responseCode = "417",description = "Something went wrong",
                    content=@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @DeleteMapping("/deleteLoan")
    public ResponseEntity<ResponseDto> deleteLoan( @RequestParam Long loanNumber){
        loansService.deleteLoanByNumber(loanNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(STATUS_200,MESSAGE_200_DELETE));
    }

    //Documentation
    @Operation(summary="GET REST API",description = "RESt API to get Loans by mobile number")
    @ApiResponses({
            @ApiResponse(responseCode ="200",description = "Request Processed Successfully"),
            @ApiResponse(responseCode = "417", description = "Unexpected Error",
                    content=@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @GetMapping("/getAllByMobile")
    public ResponseEntity<List<LoansDto>> getAllByMobile(@Valid @NotEmpty(message = "Mobile number can't be empty")
                                                             @Pattern (regexp = "^$|[0-9]{10}",message = "Invalid number")
                                                             @RequestParam String mobileNo){
        List<LoansDto>resultList= loansService.getAllByMobileNo(mobileNo);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultList);
    }

    //Documentation
    @Operation(summary="GET REST API",description = "REST API to get Loan by loan number")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request Processed Successfully"),
            @ApiResponse(responseCode = "417", description="Unexpected Error",
                    content=@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @GetMapping("/getByLoanNumber")
    public ResponseEntity<LoansDto> getByLoanNumber(@RequestParam Long loanNumber){
        LoansDto result= loansService.getByLoanNumber(loanNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    @Operation(summary="GET REST API",description = "REST API to get Loan by loan type")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request Processed Successfully"),
            @ApiResponse(responseCode = "417", description="Unexpected Error",
                    content=@Content(schema=@Schema(implementation = ErrorDto.class)))
    })
    @GetMapping("/getByLoanType")
    public ResponseEntity<List<LoansDto>> getByLoanType(@Valid @NotEmpty(message="Loan type can't be empty")
                                                            @RequestParam String loanType ){
        List<LoansDto> resultList= loansService.getByLoanType(loanType);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultList);
    }

    @Value("${build.version}")
    private String buildVersion;

    @GetMapping("/build-version")
    public String getBuildVersion(){
        return buildVersion;
    }

    @Autowired
    private LoansContactInfo loansContactInfo;

    @GetMapping("/contact-info")
    public LoansContactInfo getLoansContactInfo(){
        return loansContactInfo;
    }
}
