package com.eljc.carsale.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eljc.carsale.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager autManager;
	
	@PostMapping
	public ResponseEntity<?> authenticate(@RequestBody @Valid LoginForm form){
		
		return ResponseEntity.ok().build();
	}

}
