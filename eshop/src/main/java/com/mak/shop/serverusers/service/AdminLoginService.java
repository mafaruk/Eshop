package com.mak.shop.serverusers.service;

import com.mak.shop.serverusers.dao.AdminLoginDao;

public class AdminLoginService {
	
	private AdminLoginDao adminLoginDao;
	
	public boolean authenticateUser(String userName, String Password) {

		return this.adminLoginDao.checkUserCreadential(userName, Password);

	}

	public String getUserName() {
		return this.adminLoginDao.getUserName();
	}

	public AdminLoginService() {
		this.adminLoginDao = new AdminLoginDao();
	}
}
