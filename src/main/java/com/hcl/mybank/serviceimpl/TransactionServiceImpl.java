package com.hcl.mybank.serviceimpl;

<<<<<<< HEAD
import java.time.LocalDateTime;

=======
import java.util.Optional;
>>>>>>> 342b76c26a4fe827214f081c80839e2bbe25049f
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.entity.Account;
import com.hcl.mybank.entity.Transaction;
import com.hcl.mybank.exception.ResourceNotFoundException;
import com.hcl.mybank.repository.AccountRepository;
import com.hcl.mybank.repository.TransactionRepository;
import com.hcl.mybank.service.TransactionService;

@Component
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	AccountRepository accountRepository;

	
	@Autowired
	TransactionRepository transactionRepository;
	
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
	
	
	 public boolean validtransaction(long accountNo) throws ResourceNotFoundException
	   {
		   Account account=accountRepository.findById(accountNo).orElseThrow(()->new ResourceNotFoundException("account not exist"));
	       	  	if(transactionRepository.findByFromAccountAndTransactionDate(account, LocalDateTime.now())>=account.getTransactionLimit()) {
	       	  		
	       	  	}
		   
		   
		   return true;
	    }

}
