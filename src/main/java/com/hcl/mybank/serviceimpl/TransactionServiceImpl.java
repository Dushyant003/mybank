package com.hcl.mybank.serviceimpl;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hcl.mybank.dto.AccountsDetailsDto;
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
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Value("${minimumBalance}")
	private long minimumBalance;
	
	@Override
	public Transaction fundTransfer(TransactionDto transactionDto) {
		Optional<Account> fromAccountDetails=accountRepository.findById(transactionDto.getFromAccountId());
		Optional<Account> toAccountDetails=accountRepository.findById(transactionDto.getToAccountId());
		Transaction transaction;
		
		Boolean validate=	validateFundTransfer(transactionDto);
		
		if(validate) {
			transaction=new Transaction();
			BeanUtils.copyProperties(transactionDto, transaction);
			transaction.setFromAccount(fromAccountDetails.get());
			transaction.setToAccount(toAccountDetails.get());
			transaction.setTransactionAmount(transactionDto.getAmount());
			transaction.setTransactionDate(LocalDateTime.now());
			transaction.setTransactionDescription(transactionDto.getTransactionDescription());
			transaction.setTransactionType("CR");
			
			
			
		}
		
		
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


	public List<AccountsDetailsDto> getTransactionDetails(long id) {
		return transactionRepository.getAccountsDetails(id);
	}

	@Override
	public boolean validtransaction1(long accountNo) throws ResourceNotFoundException, TransactionLimitOverException {
		// TODO Auto-generated method stub
		return false;
	}

}
