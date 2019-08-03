package com.hcl.mybank.serviceimpl;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.entity.Account;
import com.hcl.mybank.exception.ResourceNotFoundException;
import com.hcl.mybank.repository.AccountRepository;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TransactionServiceImplTest {
	
	@InjectMocks
	TransactionServiceImpl transactionServiceimpl;
	
	@Mock
	AccountRepository accountRepository;
	
	TransactionDto transactionDto;
	Account fromAccount;
	Account toAccount;
	
	
	@Before
	public void setUp() {
		
		fromAccount=new Account();
		
			fromAccount.setAccountId(123L);
			fromAccount.setAccountType("Saving");
			fromAccount.setBalance(40000D);
			fromAccount.setTransactionLimit(20000D);
			fromAccount.setAccountCreationDate(LocalDate.of(2019, 01, 01));
		
		 toAccount=new Account();
			toAccount.setAccountId(321L);
			toAccount.setAccountType("Saving");
			toAccount.setBalance(30000D);
			toAccount.setTransactionLimit(20000D);
			toAccount.setAccountCreationDate(LocalDate.of(2018, 01, 01));
			
		transactionDto=new TransactionDto();	
			transactionDto.setFromAccountId(123L);
			transactionDto.setToAccountId(321L);
			transactionDto.setAmount(2000D);
			transactionDto.setTransactionDescription("EMI");
	}
	
	@Test
	public void fundTransferFromAccountScenarioTest() throws ResourceNotFoundException {
		Mockito.when(accountRepository.findById(123L)).thenReturn(Optional.of(fromAccount));
		Mockito.when(accountRepository.findById(321L)).thenReturn(Optional.of(toAccount));
		//assertNotNull(transactionServiceimpl.fundTransfer(transactionDto));
	}
	
	
	
}
