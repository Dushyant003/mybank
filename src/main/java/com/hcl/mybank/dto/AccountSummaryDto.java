package com.hcl.mybank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountSummaryDto {
	
	private String customerName; 
	private String accountType;
	private Double balance;
	private Long accountId;
	

}
