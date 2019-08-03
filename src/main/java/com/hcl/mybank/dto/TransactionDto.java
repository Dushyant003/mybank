package com.hcl.mybank.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TransactionDto {
	
	@NotNull
	private Long fromAccount;
	@NotNull
	private Long toAccount;
	@NotNull
	private Double amount;
	@NotNull
	private String transactionDescription;
	
	
}
