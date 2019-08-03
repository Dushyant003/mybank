package com.hcl.mybank.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.dto.AccountsDetailsDto;
import com.hcl.mybank.entity.Account;
import com.hcl.mybank.entity.Transaction;

@Repository 
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	@Query("Select new com.hcl.mybank.dto.AccountsDetailsDto( t.transactionAmount,t.transactionDate,t.transactionType,t.fromAccount.accountId,t.toAccount.accountId) from  Transaction t where t.fromAccount.accountId=:id order by t.transactionDate desc")
	public List<AccountsDetailsDto> getAccountsDetails(@Param("id")  long id);

	@Query("select sum(t.transactionAmount) from  Transaction t where t.fromAccount=:accountNo and DATE(t.transactionDate)=:trdate")
	public Double getFromAccountAndTransactionDate(@Param("accountNo")Account account,@Param("trdate")Date datetime);
	
}
