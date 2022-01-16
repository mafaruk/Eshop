package com.mak.shop.eshop.service;

import com.mak.shop.eshop.dao.LoginDao;

public class LoginService {

	private LoginDao loginDao;

	public LoginService() {
		
		this.loginDao = new LoginDao();
	}
	
	public boolean authenticateUser(String userName, String Password) {
		
		return this.loginDao.checkUserCreadential(userName, Password);
		
	} 
	
	public String getUserName() {
		return this.loginDao.getUserName();
	}
}
