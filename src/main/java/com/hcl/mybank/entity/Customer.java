package com.hcl.mybank.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long customerId;
	
	@Column(name="customer_name")
	private String customerName; 
	
	@Column(name="username")
	private String username; 
	
	@Column(name="password")
	private String password; 
	
	@Column(name="gender")
	private String gender; 
	
	@Column(name="email")
	private String email; 
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	
	
	
}
