package com.bank.transactionservice.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.transactionservice.entity.Transaction;
import com.bank.transactionservice.entity.TransactionStatus;
import com.bank.transactionservice.entity.TransactionType;
import com.bank.transactionservice.repository.TransactionRepo;
import com.bank.transactionservice.service.TransactionService;
import com.bank.transactionservice.validations.TransactionValidations;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionserviceImpl implements TransactionService{
	
	@Autowired
	TransactionRepo transactionRepository;
	
	@Autowired
	TransactionValidations validation;
	
	@Autowired
	 RestTemplate restTemplate;

//	@Override
//	public BigDecimal deposit(Transaction transaction) {	
//
//	    // Prepare request to AccountService
//	    String accountServiceUrl = "http://localhost:5050/accounts/" + transaction.getSourceAccountNumber() + "/deposit";
//
//	    Map<String, BigDecimal> requestBody = new HashMap<>();
//	    requestBody.put("amount", transaction.getAmount());
//
//	    //headers to the account service call
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    HttpEntity<Map<String, BigDecimal>> requestEntity = new HttpEntity<>(requestBody, headers);
//
//	    ResponseEntity<Map> responseEntity = restTemplate.exchange(
//	            accountServiceUrl,
//	            HttpMethod.PUT,
//	            requestEntity,
//	            Map.class
//	    );
//
//	    // Get new balance from AccountService
//	    BigDecimal newBalance = new BigDecimal(responseEntity.getBody().get("newBalance").toString());
//
//	    // Save transaction record
//	    transaction.setType(TransactionType.DEPOSIT);
//	    transaction.setTimestamp(LocalDateTime.now());
//	    transaction.setStatus(TransactionStatus.SUCCESS);
//	    transactionRepository.save(transaction);
//
//	    return newBalance;
//	}
//
//	@Override
//	public BigDecimal withdraw(String accountNumber, BigDecimal amount) {
//		
//		Transaction transaction = new Transaction();
//		// Prepare request to AccountService
//	    String accountServiceUrl = "http://localhost:5050/accounts/" + accountNumber +"/withdraw";
//	    Map<String, BigDecimal> requestBody = new HashMap<>();
//	    requestBody.put("amount", amount);
//	    
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    HttpEntity<Map<String, BigDecimal>> requestEntity = new HttpEntity<>(requestBody, headers);
//
//	    ResponseEntity<Map> responseEntity = restTemplate.exchange(
//	            accountServiceUrl,
//	            HttpMethod.PUT,
//	            requestEntity,
//	            Map.class
//	    );
//	    
//	 // Get updated balance from AccountService
//	    BigDecimal updatedBalance = new BigDecimal(responseEntity.getBody().get("updatedBalance").toString());
//
//	    // Save transaction record
//	    transaction.setType(TransactionType.WITHDRAW);
//	    transaction.setTimestamp(LocalDateTime.now());
//	    transaction.setStatus(TransactionStatus.SUCCESS);
//	    transaction.setSourceAccountNumber(accountNumber);
//	    transaction.setAmount(amount);
//	    transactionRepository.save(transaction);
//	    	    
//	      
//		return updatedBalance;
//	}
//
//	@Override
//	public BigDecimal transfer(Transaction transaction) {
//		
//		// Prepare request to AccountService
//	    String accountServiceUrl = "http://localhost:5050/accounts/" + transaction.getSourceAccountNumber() +
//	    		"/transfer/" + transaction.getTargetAccountNumber();
//
//	    Map<String, BigDecimal> requestBody = new HashMap<>();
//	    requestBody.put("amount", transaction.getAmount());
//
//	    
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    HttpEntity<Map<String, BigDecimal>> requestEntity = new HttpEntity<>(requestBody, headers);
//
//	    ResponseEntity<Map> responseEntity = restTemplate.exchange(
//	            accountServiceUrl,
//	            HttpMethod.PUT,
//	            requestEntity,
//	            Map.class
//	    );
//
//	    // Get new balance from AccountService
//	    BigDecimal transferAmount = new BigDecimal(responseEntity.getBody().get("transferAmount").toString());
//
//	    // Save transaction record
//	    transaction.setType(TransactionType.TRANSFER);
//	    transaction.setTimestamp(LocalDateTime.now());
//	    transaction.setStatus(TransactionStatus.SUCCESS);
//	    transactionRepository.save(transaction);
//
//	    return transferAmount;
//	}

	@Override
	public BigDecimal saveFromDTO(Transaction transaction) {

	    if (transaction.getType() == TransactionType.DEPOSIT ||
	        transaction.getType() == TransactionType.WITHDRAW ||
	        transaction.getType() == TransactionType.TRANSFER) {
	        
	        transaction.setTimestamp(LocalDateTime.now());
	        transaction.setStatus(TransactionStatus.SUCCESS);
	        transactionRepository.save(transaction);
	    }

	    return transaction.getAmount(); // Or whatever you want to return
	}



}
