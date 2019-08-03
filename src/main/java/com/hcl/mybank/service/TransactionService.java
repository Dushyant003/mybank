package com.hcl.mybank.service;

import org.springframework.stereotype.Service;

import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.entity.Transaction;

@Service
public interface TransactionService {

	Transaction fundTransfer(TransactionDto transactionDto);
	
	

}
