package com.bank.transactionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TransactionserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionserviceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
