package com.bank.transactionservice.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.bank.transactionservice.entity.Transaction;
import com.bank.transactionservice.entity.TransactionDTO;
import com.bank.transactionservice.entity.TransactionStatus;
import com.bank.transactionservice.entity.TransactionType;
import com.bank.transactionservice.repository.TransactionRepo;

@Component
public class transactionConsumer {
	
	@Autowired
	TransactionRepo transactionRepository;

	@KafkaListener(topics = "failed-transactions", groupId = "transaction-consumer-group")
    public void processFailedTransaction(Transaction dto) {
        // Retry storing transaction
        try {
        	 if (dto.getType() == TransactionType.DEPOSIT ||
        			 dto.getType() == TransactionType.WITHDRAW ||
        					 dto.getType() == TransactionType.TRANSFER) {
        		        
        		 dto.setTimestamp(LocalDateTime.now());
        		 dto.setStatus(TransactionStatus.SUCCESS);
        		        transactionRepository.save(dto);
        		    }
        	 
            System.out.println("Processing failed transaction: " + dto);
        } catch (Exception e) {
            // log or send to a DLQ (Dead Letter Queue)
        }
    }
}
