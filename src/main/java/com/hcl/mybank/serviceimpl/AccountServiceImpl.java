package com.hcl.mybank.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.mybank.dto.AccountSummaryDto;
import com.hcl.mybank.exception.ResourceNotFoundException;
import com.hcl.mybank.repository.AccountRepository;
import com.hcl.mybank.service.AccountService;

@Component
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<AccountSummaryDto> accountSummary(long customerId) throws ResourceNotFoundException {
		//return accountRepository.findUserSummary();
		return null;
	}
	
	
}
