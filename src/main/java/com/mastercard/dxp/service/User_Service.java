package com.mastercard.dxp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.dxp.entity.User_credential;
import com.mastercard.dxp.repository.User_Repository;

@Service
public class User_Service {
	
	
	@Autowired
	public User_Repository user_Repo;
	
	public boolean validateUser(String userName, String password) {
		
		User_credential user=user_Repo.findByUserNameAndPassword(userName,password);
		
		if(user.getUserName().equals(userName) && user.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		
	
}
