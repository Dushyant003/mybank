package com.hcl.mybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.dto.AccountSummaryDto;
import com.hcl.mybank.entity.Account;
import com.hcl.mybank.entity.Customer;

@Repository
	public interface AccountRepository  extends JpaRepository<Account, Long>{

		Account findByCustomerId(Customer customer);
		@Query("select new com.hcl.mybank.dto.AccountSummaryDto(a.customerId.customerName,a.accountType,a.balance,a.accountId) FROM Customer c , Account a where a.customerId.customerId=c.customerId and a.customerId=:customerId")
		public List<AccountSummaryDto> findUserSummary(@Param("customerId")Customer customer);
		
	 	@Query("select a.accountId from Account a where a.accountId!=:accountno")
		public List<Long> findByAccountIdNot(@Param("accountno") long accountno);
	}







	





