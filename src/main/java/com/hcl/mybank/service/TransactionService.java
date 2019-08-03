package com.hcl.mybank.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.hcl.mybank.dto.ResponseDto;

import com.hcl.mybank.dto.AccountsDetailsDto;

import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.exception.ResourceNotFoundException;
import com.hcl.mybank.exception.TransactionLimitOverException;

@Transactional
@Service
public interface TransactionService {


	public ResponseDto fundTransfer(TransactionDto transactionDto) throws ResourceNotFoundException;
	
	public boolean validtransaction1(long accountNo) throws ResourceNotFoundException, TransactionLimitOverException;
	
	public List<AccountsDetailsDto> getTransactionDetails(long id);


	public boolean validtransaction(long accountNo) throws ResourceNotFoundException,TransactionLimitOverException;


}
