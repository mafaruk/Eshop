package com.mak.shop.eshop.service;

import com.mak.shop.eshop.dao.LoginDao;
import com.mak.shop.eshop.entity.UserDetails;

public class LoginService {

	private LoginDao loginDao;

	public LoginService() {
		
		this.loginDao = new LoginDao();
	}
	
	public boolean authenticateUser(String userName, String Password) {
		
		return this.loginDao.checkUserCreadential(userName, Password);
		
	} 
	
	public UserDetails getUserDetails() {
		return this.loginDao.getUserDetails();
	}
}
