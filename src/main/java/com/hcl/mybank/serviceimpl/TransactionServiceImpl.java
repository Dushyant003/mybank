package com.hcl.mybank.serviceimpl;

import org.springframework.stereotype.Service;

import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.entity.Transaction;
import com.hcl.mybank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Override
	public Transaction fundTransfer(TransactionDto transactionDto) {
		
		return null;
	}

}
