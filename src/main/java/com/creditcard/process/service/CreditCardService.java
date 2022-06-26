package com.creditcard.process.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.creditcard.process.models.CreditCardDetails;
import com.creditcard.process.models.CreditCardRequest;

@Service
public interface CreditCardService {

	List<CreditCardDetails> getCardDetails();

	CreditCardDetails saveCardDetails(CreditCardRequest cardRequest);

}
