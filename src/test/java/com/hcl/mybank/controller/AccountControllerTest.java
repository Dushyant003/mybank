package com.hcl.mybank.controller;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.mybank.dto.AccountsDetailsDto;
import com.hcl.mybank.serviceimpl.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {
	
	@InjectMocks
	AccountController accountController;
	
	@Mock
	AccountServiceImpl accountServiceImpl;
	
	
	
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testgetAccountsDeails() {
		List<AccountsDetailsDto> list = new ArrayList<AccountsDetailsDto>();
		long id=1234;
		Mockito.when(accountController.getAccountsDeails(id).equals(list)).thenReturn(null);
		assertNotNull(accountController.getAccountsDeails(id));
		
		
	}

}
