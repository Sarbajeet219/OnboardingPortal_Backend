package com.mastercard.dxp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.dxp.entity.User_credential;
import com.mastercard.dxp.service.User_Service;
@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "*")
public class User_Controller {

	@Autowired
	public User_Service user_Serev;
	
	@PostMapping("/login")
	public ResponseEntity<String> validateUser(@RequestBody User_credential user)
	{
		boolean isvalid=user_Serev.validateUser(user.getUserName(),user.getPassword());
		if(isvalid)
		{
		return	new ResponseEntity<>("login successful", HttpStatus.OK);	
		}
		else
		{
		return new ResponseEntity<>("login failed", HttpStatus.BAD_REQUEST);
		}
		
	}
				
}

