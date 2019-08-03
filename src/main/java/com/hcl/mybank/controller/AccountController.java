package com.hcl.mybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.exception.ResourceNotFoundException;
import com.hcl.mybank.service.AccountService;
import com.hcl.mybank.service.TransactionService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class AccountController {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/fundtransfer")
	public ResponseEntity<Object> fundTransfer(@RequestBody TransactionDto transactionDto) throws ResourceNotFoundException {
		return new ResponseEntity<>(transactionService.fundTransfer(transactionDto),HttpStatus.OK);		
	}
	
	
	@GetMapping("/summary")
	public ResponseEntity<Object> summary(@RequestParam long customerId) throws ResourceNotFoundException
	{
		return new ResponseEntity<>(accountService.accountSummary(customerId),HttpStatus.OK);
	}

}
