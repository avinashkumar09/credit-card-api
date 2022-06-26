package com.creditcard.process.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.process.models.CreditCardDetails;


@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardDetails, Long>{

}
