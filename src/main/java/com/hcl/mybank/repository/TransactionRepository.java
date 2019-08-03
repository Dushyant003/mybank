package com.hcl.mybank.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.entity.Account;
import com.hcl.mybank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	@Query("select sum(t.transactionAmount) from  Transaction t where t.fromAccount=:accountNo and DATE(t.transactionDate)=:trdate")
	public Double getFromAccountAndTransactionDate(@Param("accountNo")Account account,@Param("trdate")Date datetime);
	
}
