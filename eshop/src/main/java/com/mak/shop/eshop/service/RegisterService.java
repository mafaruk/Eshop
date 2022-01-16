package com.mak.shop.eshop.service;

import com.mak.shop.eshop.dao.RegisterDao;
import com.mak.shop.eshop.entity.UserDetails;

public class RegisterService {

	RegisterDao registerDao;
	
	public RegisterService() {
		this.registerDao  = new RegisterDao();
	}
	
	public int addUser(UserDetails userDetails) {
		this.registerDao.start();
		int userID = this.registerDao.adduser(userDetails);
		this.registerDao.close();
		return userID;
		
	}
	
	public boolean checkUserNameEmail(String email) {
		
		boolean isAvailble =  this.registerDao.checkUserNameEmail(email);
		return isAvailble;
	}
	
	
}
