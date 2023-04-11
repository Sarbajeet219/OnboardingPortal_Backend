package com.mastercard.dxp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.dxp.entity.User_credential;
import com.mastercard.dxp.repository.User_Repository;

@Service
public class User_Service {
	@Autowired
	public User_Repository user_Repo;

	public String validateUser(String userName, String password) {

		User_credential user = user_Repo.findByUserName(userName);
		if (user == null) {
			return "User not found";
		}
		if (!user.getPassword().equals(password)) {
			return "password incorrect";
		}

		return "User signedUp successfully";

	}

	public String signUp(User_credential user) {

		User_credential existingUser = user_Repo.findByUserName(user.getUserName());

		if (existingUser != null) {
			return "Username is already exsits";
		}
		if (!user.getConfirm_password().equals(user.getPassword())) {
			return "password and confirm password must be same";
		} else {
			user_Repo.save(user);
			return "User login successfully";
		}
	}

}
