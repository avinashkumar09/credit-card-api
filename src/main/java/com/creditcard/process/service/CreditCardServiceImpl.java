package com.creditcard.process.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.creditcard.process.models.CreditCardDetails;
import com.creditcard.process.models.CreditCardRequest;
import com.creditcard.process.repository.CreditCardRepository;

/**
 * @author avinash
 *
 */
@Service
public class CreditCardServiceImpl implements CreditCardService{
	
	@Autowired
	private CreditCardRepository cardRepository;

	
	/**
	 *This method fetches all the records from DB
	 */
	@Override
	public List<CreditCardDetails> getCardDetails() throws DataAccessException{
		return cardRepository.findAll();
	}
	
	

	/**
	 * This methods saves the credit cards details in the DB
	 */
	@Override
	public CreditCardDetails saveCardDetails(CreditCardRequest cardRequest)  throws DataAccessException{
		
		CreditCardDetails cardDetails = new CreditCardDetails();
		cardDetails.setName(cardRequest.getName());
		cardDetails.setCardNumber(cardRequest.getCardNumber());
		cardDetails.setCardLimit(cardRequest.getLimit());
		cardDetails.setBalance(cardRequest.getBalance());
		return cardRepository.save(cardDetails);
	}

}
