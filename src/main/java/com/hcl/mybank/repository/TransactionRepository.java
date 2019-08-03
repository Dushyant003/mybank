package com.hcl.mybank.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.dto.AccountsDetailsDto;
import com.hcl.mybank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	@Query("")
	public List<AccountsDetailsDto> getAccountsDetails(@PathParam("id")  long id);
}
