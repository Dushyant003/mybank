package com.hcl.mybank.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="account")
@Data
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id")
	private Long accountId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customer_id")
	private Customer customerId;
	
	@Column(name="account_creation_date")
	private LocalDate accountCreationDate;
	
	@Column(name="balance")
	private Double balance;
	
	@Column(name="account_type")
	private Double accountType;
	
	@Column(name="transaction_limit")
	private Double transactionLimit;
	
	

}
