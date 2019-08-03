package com.hcl.mybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.entity.Transaction;
import com.hcl.mybank.service.TransactionService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/fundtransfer")
	public void fundTransfer(@RequestBody TransactionDto transactionDto) {
	  Transaction transactionDetails=	transactionService.fundTransfer(transactionDto);
		
		
	}

}
