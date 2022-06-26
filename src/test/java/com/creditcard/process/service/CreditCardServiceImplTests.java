package com.creditcard.process.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.creditcard.process.models.CreditCardDetails;
import com.creditcard.process.repository.CreditCardRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreditCardServiceImplTests {
	
	@Autowired
	private CreditCardRepository cardRepository;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
    @Order(1)
    @Rollback(value = false)
	public void saveCardDetailsTest() {
		
		CreditCardDetails cardDetails =  new CreditCardDetails();
		
		cardDetails.setName("Test");
		cardDetails.setCardNumber("1254658697989759");
		cardDetails.setBalance(0.0);
		cardDetails.setCardLimit(100.0);
		
		cardRepository.save(cardDetails);
		
		Assertions.assertThat(cardDetails.getId()).isGreaterThan(0);
		
		
	}
	
	
	 @Test
	 @Order(2)
	public void getCardDetailsTest() {
		
		 List<CreditCardDetails> cardDetails = cardRepository.findAll();

	        Assertions.assertThat(cardDetails.size()).isGreaterThan(0);
	}
	

}
