package com.hcl.mybank.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payee")
public class Payee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payee_id")
	private Long payeeId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@Column(name="account_id")
	private Account accountId;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Column(name="payee_account_id")
	private List<Account> payeeAccountId;
	
	

}
