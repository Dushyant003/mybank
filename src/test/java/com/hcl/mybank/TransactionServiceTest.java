package com.hcl.mybank;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.hcl.mybank.entity.Account;
import com.hcl.mybank.entity.Customer;
import com.hcl.mybank.entity.Transaction;
import com.hcl.mybank.exception.ResourceNotFoundException;
import com.hcl.mybank.exception.TransactionLimitOverException;
import com.hcl.mybank.repository.AccountRepository;
import com.hcl.mybank.repository.TransactionRepository;
import com.hcl.mybank.serviceimpl.TransactionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;
	
	@Mock
	AccountRepository accountRepository;
	
	@Mock
	TransactionRepository transactionRepository;
	
	Account account,account1;
	Customer customer;
	Transaction transaction;
	
	@Before
	public void setMockUp() {
	
		
		
        
        
		customer=new Customer();
		customer.setCustomerId(Long.valueOf(1));
		customer.setCustomerName("vinayak");
		customer.setEmail("vinayak@gmail.com");
		customer.setGender("M");
		customer.setUsername("test");
		customer.setPassword("test");
		
		account =new Account();
		account.setAccountId(Long.valueOf(1));
		account.setAccountCreationDate(LocalDate.now());
		account.setAccountType("saving");
		account.setBalance(Double.valueOf(2000));
		account.setCustomerId(customer);
		account.setTransactionLimit(Double.valueOf(1000));
		
		account1 =new Account();
		account1.setAccountId(Long.valueOf(2));
		account1.setAccountCreationDate(LocalDate.now());
		account1.setAccountType("saving");
		account1.setBalance(Double.valueOf(2000));
		account1.setCustomerId(customer);
		account1.setTransactionLimit(Double.valueOf(1000));
		
		transaction=new Transaction();
		transaction.setTransactionId(Long.valueOf(1));
		transaction.setTransactionType("credit");
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setTransactionDescription("test");
        transaction.setTransactionId(Long.valueOf(1));
        transaction.setFromAccount(account);
		transaction.setToAccount(account1);
		
	}
	
	@Test
	public void testTrasactionValidationTest() throws ResourceNotFoundException, TransactionLimitOverException {
		Mockito.when(accountRepository.findById(1l)).thenReturn(Optional.of(account));
		assertNotNull(transactionServiceImpl.validtransaction(Long.valueOf(1)));
	}
	
	
	@Test
	public void testTrasactionValidationMinimumBalanceTest() throws ResourceNotFoundException, TransactionLimitOverException {
		Mockito.when(accountRepository.findById(2l)).thenReturn(Optional.of(account));
		Mockito.when(transactionRepository.getFromAccountAndTransactionDate(account, new Date())).thenReturn(null);
		//assertNotNull(transactionServiceImpl.validtransaction(Long.valueOf(1)));
	}
}
