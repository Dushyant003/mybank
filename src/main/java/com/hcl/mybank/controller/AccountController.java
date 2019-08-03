package com.hcl.mybank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.mybank.dto.AccountsDetailsDto;
import com.hcl.mybank.exception.ResourceNotFoundException;
import com.hcl.mybank.service.AccountService;
import com.hcl.mybank.serviceimpl.TransactionServiceImpl;
@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class AccountController {
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	
	@Autowired
	AccountService accountService;
	@GetMapping(value="/account/details/{id}")
	public List<AccountsDetailsDto> getAccountsDeails(@PathVariable long id){
		
		return transactionServiceImpl.getTransactionDetails(id);
	}
	
	@GetMapping("/summary")
	public ResponseEntity<Object> summary(@RequestParam long customerId) throws ResourceNotFoundException
	{
		return new ResponseEntity<>(accountService.accountSummary(customerId),HttpStatus.OK);
	}
	@GetMapping("/beneficiaryDetails")
	public ResponseEntity<Object> beneficiaryDetails(@RequestParam long accountId) throws ResourceNotFoundException
	{
		return new ResponseEntity<>(accountService.beneficiaryDetails(accountId),HttpStatus.OK);
	}
}
