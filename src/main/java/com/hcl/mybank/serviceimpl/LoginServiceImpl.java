package com.hcl.mybank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mybank.dto.LoginDto;
import com.hcl.mybank.entity.Customer;
import com.hcl.mybank.repository.AccountRepository;
import com.hcl.mybank.repository.CustomerRepository;
import com.hcl.mybank.service.LoginService;



	
@Service
public class LoginServiceImpl  implements LoginService{
	@Autowired
	CustomerRepository  customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	
	


	@Override
	public Customer loginUser(LoginDto customerDto) {
	   return customerRepository.findByCustomerIdAndPassword(customerDto.getCustomerId(), customerDto.getPassword());
	}


}

	
	
	
	


