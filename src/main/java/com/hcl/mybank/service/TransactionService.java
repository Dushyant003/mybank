package com.hcl.mybank.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.mybank.dto.ResponseDto;
import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.exception.ResourceNotFoundException;
import com.hcl.mybank.exception.TransactionLimitOverException;

@Transactional
@Service
public interface TransactionService {

	public ResponseDto fundTransfer(TransactionDto transactionDto) throws ResourceNotFoundException;

	public boolean validtransaction(long accountNo) throws ResourceNotFoundException,TransactionLimitOverException;


}
