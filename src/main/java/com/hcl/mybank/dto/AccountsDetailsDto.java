package com.hcl.mybank.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountsDetailsDto {


	private LocalDate transactionDate;
    private double transactionAmount;
    private String transactionType;
	private Long fromAccount;
	private Long toAccount;
	
	
}
