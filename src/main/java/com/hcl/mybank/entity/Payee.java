package com.hcl.mybank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="payee")
public class Payee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payee_id")
	@Getter
	@Setter
	private Long payeeId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="account_id")
	@Getter
	@Setter
	private Account accountId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="payee_account_id")
	@Getter
	private Account payeeAccountId;
	
	

}
