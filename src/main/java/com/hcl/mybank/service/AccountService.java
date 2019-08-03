package com.hcl.mybank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.mybank.dto.AccountSummaryDto;
import com.hcl.mybank.exception.ResourceNotFoundException;

@Service
public interface AccountService {

	//public List<ReportDto> accountSummary(long customerId) throws ResourceNotFoundException;

	public List<AccountSummaryDto> accountSummary(long customerId) throws ResourceNotFoundException;
}
