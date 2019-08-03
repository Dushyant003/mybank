package com.hcl.mybank.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mybank.dto.LoginDto;
import com.hcl.mybank.dto.ResponseDto;
import com.hcl.mybank.service.LoginService;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class CustomerController {
	
	@Autowired
	LoginService service;
	
	@PostMapping("")
	public ResponseEntity<Object>  loginUser( @Valid @RequestBody LoginDto  loginDto){
		 if(service.loginUser(loginDto)==null) {
			 return new ResponseEntity<>(new ResponseDto("fail",100,"not authinticated"),HttpStatus.BAD_REQUEST);
		 }
		
		return new ResponseEntity<>(new ResponseDto("sucess",200,service.loginUser(loginDto)),HttpStatus.OK);
	}
	

}
