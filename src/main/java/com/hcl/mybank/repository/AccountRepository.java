package com.hcl.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.mybank.entity.Account;

public interface AccountRepository  extends JpaRepository<Account, Long>{

}
