package com.hcl.mybank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.entity.Transaction;
import com.hcl.mybank.repository.AccountRepository;
import com.hcl.mybank.service.TransactionService;

@Component
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Transaction fundTransfer(TransactionDto transactionDto) {
		
		return null;
	}
	
	
	 public boolean validtransaction(long accountNo)
	   {
		 
			 return true;
	    }

}
