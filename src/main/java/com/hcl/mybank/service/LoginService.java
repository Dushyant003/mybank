package com.hcl.mybank.service;

import org.springframework.stereotype.Service;

import com.hcl.mybank.dto.LoginDto;
import com.hcl.mybank.entity.Customer;

@Service
public interface LoginService {
	
	public Customer loginUser(LoginDto customerDto);

}
