package com.hcl.mybank.dto;

import lombok.Data;

@Data
public class AccountSummaryDto {
	
	private String customerName; 
	private String accountType;
	private Double balance;
	private Long accountId;
	

}
