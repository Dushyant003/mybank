package com.hcl.mybank.serviceimpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.entity.Account;
import com.hcl.mybank.entity.Transaction;
import com.hcl.mybank.exception.ResourceNotFoundException;
import com.hcl.mybank.exception.TransactionLimitOverException;
import com.hcl.mybank.repository.AccountRepository;
import com.hcl.mybank.repository.TransactionRepository;
import com.hcl.mybank.service.TransactionService;

@Component
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	AccountRepository accountRepository;

	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Value("${minimumBalance}")
	private long minimumBalance;
	
	@Override
	public Transaction fundTransfer(TransactionDto transactionDto) {
		Optional<Account> fromAccountDetails=accountRepository.findById(transactionDto.getFromAccountId());
		Optional<Account> toAccountDetails=accountRepository.findById(transactionDto.getToAccountId());
		
		
		Boolean validate=	validateFundTransfer(transactionDto);
		
		
		return null;
	}

	private Boolean validateFundTransfer(TransactionDto transactionDto) {
		
		return null;
	}
	
	
	 public boolean validtransaction(long accountNo) throws ResourceNotFoundException, TransactionLimitOverException
	   {
		   Account account=accountRepository.findById(accountNo).orElseThrow(()->new ResourceNotFoundException("account not exist"));
	       	  	if(transactionRepository.getFromAccountAndTransactionDate(account, LocalDateTime.now())>=account.getTransactionLimit()) {
	                throw new TransactionLimitOverException("transaction limit exceeded");    	  		
	       	  	}
	       	  	if(account.getBalance()<minimumBalance) {
	       	  	throw new TransactionLimitOverException("insufficient balance");
	       	  	}
		   return true;
	    }

}
