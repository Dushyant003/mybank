package com.hcl.mybank.service;

import org.springframework.stereotype.Service;

import com.hcl.mybank.exception.ResourceNotFoundException;

@Service
public interface AccountService {

	public List<ReportDto> accountSummary(long customerId) throws ResourceNotFoundException;
}
