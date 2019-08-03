package com.hcl.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	
}
