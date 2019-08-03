package com.hcl.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.entity.Account;

import com.hcl.mybank.entity.Customer;

@Repository
	public interface AccountRepository  extends JpaRepository<Account, Long>{

		Account findByCustomerId(Customer customer);

		/*
		 * @Query("") public List<AccountSummaryDto> findUserSummary();
		 */
	}







	





