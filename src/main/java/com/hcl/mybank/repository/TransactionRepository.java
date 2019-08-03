package com.hcl.mybank.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.entity.Account;
import com.hcl.mybank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	@Query("select sum(t.transactionAmount) from  Transaction t where t.fromAccount=:accountNo and t.TransactionDate:=trdate")
	public long findByFromAccountAndTransactionDate(Account account,LocalDateTime datetime);
	
}
