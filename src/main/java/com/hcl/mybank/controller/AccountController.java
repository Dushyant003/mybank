package com.hcl.mybank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mybank.dto.AccountsDetailsDto;
import com.hcl.mybank.service.TransactionService;
import com.hcl.mybank.serviceimpl.TransactionServiceImpl;

@RestController
@RequestMapping("")
public class AccountController {
	
	
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	
	@GetMapping(value="/account/details/{id}")
	public List<AccountsDetailsDto> getAccountsDeails(@PathVariable long id){
		
		return transactionServiceImpl.getTransactionDetails(id);
	}

}
