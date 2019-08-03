package com.hcl.mybank.repository;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.dto.AccountsDetailsDto;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.entity.Account;
import com.hcl.mybank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	@Query("")
	public List<AccountsDetailsDto> getAccountsDetails(@PathParam("id")  long id);

	@Query("select sum(t.transactionAmount) from  Transaction t where t.fromAccount=:accountNo and t.transactionDate=:trdate")
	public long getFromAccountAndTransactionDate(@Param("accountNo")Account account,@Param("trdate")LocalDateTime datetime);
	
}
