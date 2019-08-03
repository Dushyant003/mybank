package com.hcl.mybank.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private Long transactionId;
	
	@Column(name="transaction_type")
	private String transactionType;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="from_account")
	private Account fromAccount;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="to_account")
	private Account toAccount;
	
	@Column(name="transaction_date")
	private LocalDateTime transactionDate;
}
