package com.hcl.mybank.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.mybank.dto.ErrorResponse;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	private String errorMessage="Server Error";
	@Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		 List<String> details = new ArrayList<>();
	        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
	            details.add(error.getDefaultMessage());
	        }
	        return new ResponseEntity<>(new ErrorResponse("Validation Failed", details,Integer.toString(HttpStatus.BAD_REQUEST.value())), HttpStatus.BAD_REQUEST);
	    }
	 
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	    public final ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {   
		 List<String> details = new ArrayList<>();
	        details.add(ex.getMessage());	        
	        return new ResponseEntity<>(new ErrorResponse(errorMessage, details,Integer.toString(301)), HttpStatus.NOT_FOUND);
	    }

	@ExceptionHandler(TransactionLimitOverException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	    public final ResponseEntity<ErrorResponse> handleTransactionLimitOverException(TransactionLimitOverException ex, WebRequest request) {   
		 List<String> details = new ArrayList<>();
	        details.add(ex.getMessage());	        
	        return new ResponseEntity<>(new ErrorResponse(errorMessage, details,Integer.toString(301)), HttpStatus.NOT_FOUND);
	    }

	
}
