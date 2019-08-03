package com.hcl.mybank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TransactionLimitOverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1649241601526012679L;

	public TransactionLimitOverException(String message) {
		super(message);
	}
}
