package com.hcl.mybank.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.mybank.dto.ResponseDto;
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
	@Transactional
	public ResponseDto fundTransfer(TransactionDto transactionDto) throws ResourceNotFoundException {
		
		Account fromAccountDetails=accountRepository.findById(transactionDto.getFromAccountId()).orElseThrow(()->new ResourceNotFoundException("From account not exist"));
		Account toAccountDetails=accountRepository.findById(transactionDto.getToAccountId()).orElseThrow(()->new ResourceNotFoundException("To account not exist"));
		
		Transaction crTransaction;		
		Transaction DrTransaction;
		
		ResponseDto transactionResponseDto = null;
		
			crTransaction=new Transaction();
			BeanUtils.copyProperties(transactionDto, crTransaction);
			
			DrTransaction=new Transaction();
			BeanUtils.copyProperties(transactionDto, DrTransaction);
			
			crTransaction.setFromAccount(fromAccountDetails);
			crTransaction.setToAccount(toAccountDetails);
			crTransaction.setTransactionAmount(transactionDto.getAmount());
			crTransaction.setTransactionDate(LocalDateTime.now());
			crTransaction.setTransactionDescription(transactionDto.getTransactionDescription());
			crTransaction.setTransactionType("DR");		
			
			DrTransaction.setFromAccount(toAccountDetails);
			DrTransaction.setToAccount(fromAccountDetails);
			DrTransaction.setTransactionAmount(transactionDto.getAmount());
			DrTransaction.setTransactionDate(LocalDateTime.now());
			DrTransaction.setTransactionDescription(transactionDto.getTransactionDescription());
			DrTransaction.setTransactionType("CR");
			
			fromAccountDetails.setBalance(fromAccountDetails.getBalance()-transactionDto.getAmount());
			toAccountDetails.setBalance(toAccountDetails.getBalance()+transactionDto.getAmount());
			
			accountRepository.save(fromAccountDetails);
			accountRepository.save(toAccountDetails);
			transactionRepository.save(crTransaction);
			transactionRepository.save(DrTransaction);
			
			transactionResponseDto=new ResponseDto("Transaction Succesfull ",200,fromAccountDetails);		
		
		return transactionResponseDto; 
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
