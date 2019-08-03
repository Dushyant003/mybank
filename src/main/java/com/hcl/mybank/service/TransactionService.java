package com.hcl.mybank.service;


import org.springframework.stereotype.Service;

import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.entity.Transaction;
import com.hcl.mybank.exception.ResourceNotFoundException;

@Service
public interface TransactionService {

	Transaction fundTransfer(TransactionDto transactionDto);
	public boolean validtransaction(long accountNo) throws ResourceNotFoundException;
	

}
