package com.hcl.mybank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6496684332862109356L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	

}
