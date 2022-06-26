package com.creditcard.process.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.process.constants.APIConstants;
import com.creditcard.process.models.CreditCardDetails;
import com.creditcard.process.models.CreditCardRequest;
import com.creditcard.process.models.CreditCardResponse;
import com.creditcard.process.service.CreditCardService;
import com.creditcard.process.utils.CreditCardProcessUtils;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class CreditCardProcessController {
	
	@Autowired
	private CreditCardService cardService;
	
	
	@GetMapping(APIConstants.GET_CARD_ENDPOINT)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "OK"),
			@ApiResponse(responseCode = "400",description = "Bad Request"),
			@ApiResponse(responseCode = "401",description = "UnAuthorized"),
			@ApiResponse(responseCode = "403",description = "Forbidden"),
			@ApiResponse(responseCode = "404",description = "Not Found"),
			@ApiResponse(responseCode = "500",description = "Internal Server Error")
	})
	@Tag(name = "GET Card Details" , description = "API To FETCH ALL CARD DETAILS")
	@ResponseStatus(HttpStatus.OK)
	public List<CreditCardDetails> getAllCardDetails() {
		return cardService.getCardDetails();
		
	}
	
	@PostMapping(APIConstants.SAVE_CARD_ENDPOINT)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201",description = "Created"),
			@ApiResponse(responseCode = "400",description = "Bad Request"),
			@ApiResponse(responseCode = "401",description = "UnAuthorized"),
			@ApiResponse(responseCode = "403",description = "Forbidden"),
			@ApiResponse(responseCode = "404",description = "Not Found"),
			@ApiResponse(responseCode = "500",description = "Internal Server Error")
	})
	@Tag(name = "Save Card Details",description = "API To SAVE CARD DETAILS")
	@ResponseStatus(HttpStatus.CREATED)
	public CreditCardResponse saveCreditCardDetails(@RequestBody @Valid CreditCardRequest cardRequest) throws Exception {
		CreditCardResponse response = new CreditCardResponse();
		if(CreditCardProcessUtils.validateCreditCardNumberLuhn(cardRequest.getCardNumber()))
		cardService.saveCardDetails(cardRequest);
		else {
			response.setMessage(APIConstants.FAILURE_MESSAGE);
			return response;
		}
		response.setMessage(APIConstants.SUCCESS_MESSAGE);
		return response;
	}

}
