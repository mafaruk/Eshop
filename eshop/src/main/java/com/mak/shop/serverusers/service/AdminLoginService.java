package com.mak.shop.serverusers.service;

import com.mak.shop.serverusers.dao.AdminLoginDao;
import com.mak.shop.serverusers.entity.AdminUsers;

public class AdminLoginService {
	
	private AdminLoginDao adminLoginDao;
	
	public boolean authenticateUser(String userName, String Password) {

		return this.adminLoginDao.checkUserCreadential(userName, Password);

	}

	public AdminUsers getAdminUsers() {
		return this.adminLoginDao.getAdminUsers();
	}

	public AdminLoginService() {
		this.adminLoginDao = new AdminLoginDao();
	}
}
