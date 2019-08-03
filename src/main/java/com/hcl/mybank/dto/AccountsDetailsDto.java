package com.hcl.mybank.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.hcl.mybank.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountsDetailsDto {


	
    private double transactionAmount;
    private LocalDateTime transactionDate;
    private String transactionType;
	private Long fromAccount;
	private Long toAccount;
	
	
}
