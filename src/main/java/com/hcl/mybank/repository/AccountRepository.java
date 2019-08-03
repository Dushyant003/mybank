package com.hcl.mybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.dto.AccountSummaryDto;
import com.hcl.mybank.entity.Account;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long>{

	//public List<AccountSummaryDto> findAnalysisReportWeekly();

}
