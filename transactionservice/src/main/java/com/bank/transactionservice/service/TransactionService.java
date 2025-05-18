package com.bank.transactionservice.service;

import java.math.BigDecimal;

import com.bank.transactionservice.entity.Transaction;

public interface TransactionService {

//public BigDecimal deposit(Transaction transaction);
//
//public BigDecimal withdraw(String accountNumber, BigDecimal amount);
//
//public BigDecimal transfer(Transaction transaction);

public BigDecimal saveFromDTO(Transaction transaction);

}
