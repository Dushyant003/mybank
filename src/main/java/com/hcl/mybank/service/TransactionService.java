package com.hcl.mybank.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.mybank.dto.AccountsDetailsDto;
import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.entity.Transaction;
import com.hcl.mybank.exception.ResourceNotFoundException;

@Service
public interface TransactionService {

	public Transaction fundTransfer(TransactionDto transactionDto);
	public boolean validtransaction(long accountNo) throws ResourceNotFoundException;
	
	public List<AccountsDetailsDto> getTransactionDetails(long id);
	

}
