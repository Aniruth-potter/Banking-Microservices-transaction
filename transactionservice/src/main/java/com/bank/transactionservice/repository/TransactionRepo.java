package com.bank.transactionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.transactionservice.entity.Transaction;



@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long>{

}
