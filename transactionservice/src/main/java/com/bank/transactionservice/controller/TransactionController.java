package com.bank.transactionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.transactionservice.entity.Transaction;
import com.bank.transactionservice.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	TransactionService transactionservice;
	
	@PostMapping("/save")
	public ResponseEntity<Void> saveTransaction(@RequestBody Transaction Transaction) {
	    transactionservice.saveFromDTO(Transaction);
	    return ResponseEntity.ok().build();
	}
	
//	// deposit amount
//    @PostMapping("/deposit")
//    public ResponseEntity<BigDecimal> depositAmount(@Validated @RequestBody Transaction transaction) {
//    	BigDecimal depositAmount = transactionservice.deposit(transaction);
//        return new ResponseEntity<>(depositAmount, HttpStatus.CREATED);
//    }
//    
// // withdraw amount
//    @PostMapping("/withdraw/{accountNumber}/{amount}")
//    public ResponseEntity<BigDecimal> withdrawAmount(@PathVariable String accountNumber,@PathVariable BigDecimal amount) {
//    	BigDecimal withdrawnAmount = transactionservice.withdraw(accountNumber,amount);
//        return new ResponseEntity<>(withdrawnAmount, HttpStatus.CREATED);
//    }
//    
// // transfer amount
//    @PostMapping("/transfer")
//    public ResponseEntity<BigDecimal> transferAmount(@Validated @RequestBody Transaction transaction) {
//    	BigDecimal transferAmount = transactionservice.transfer(transaction);
//        return new ResponseEntity<>(transferAmount, HttpStatus.CREATED);
//    }
}
