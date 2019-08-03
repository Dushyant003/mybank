package com.hcl.mybank.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.mybank.dto.AccountsDetailsDto;
import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.entity.Transaction;
import com.hcl.mybank.repository.TransactionRepository;
import com.hcl.mybank.service.TransactionService;

@Component
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public Transaction fundTransfer(TransactionDto transactionDto) {
		
		return null;
	}
	
	
	 public boolean validtransaction(long accountNo)
	   {
		 
			 return true;
	    }


	public List<AccountsDetailsDto> getTransactionDetails(long id) {
		return transactionRepository.getAccountsDetails(id);
	}

}
