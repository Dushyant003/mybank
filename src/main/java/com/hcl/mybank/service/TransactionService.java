package com.hcl.mybank.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import com.hcl.mybank.dto.ResponseDto;
=======
import com.hcl.mybank.dto.AccountsDetailsDto;
>>>>>>> 612cccf3db457e060fc29c32b65d11452f76516d
import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.exception.ResourceNotFoundException;
import com.hcl.mybank.exception.TransactionLimitOverException;

@Transactional
@Service
public interface TransactionService {

<<<<<<< HEAD
	public ResponseDto fundTransfer(TransactionDto transactionDto) throws ResourceNotFoundException;
=======
	public Transaction fundTransfer(TransactionDto transactionDto);
	public boolean validtransaction1(long accountNo) throws ResourceNotFoundException, TransactionLimitOverException;
	
	public List<AccountsDetailsDto> getTransactionDetails(long id);
>>>>>>> 612cccf3db457e060fc29c32b65d11452f76516d

	public boolean validtransaction(long accountNo) throws ResourceNotFoundException,TransactionLimitOverException;


}
