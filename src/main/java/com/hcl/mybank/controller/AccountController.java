package com.hcl.mybank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mybank.dto.AccountsDetailsDto;
import com.hcl.mybank.serviceimpl.TransactionServiceImpl;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class AccountController {
	
	
	
	

	
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	
	
	@GetMapping(value="/account/details")
	public List<AccountsDetailsDto> getAccountsDeails(@RequestParam long id){
		
		return transactionServiceImpl.getTransactionDetails(id);
	}


}
