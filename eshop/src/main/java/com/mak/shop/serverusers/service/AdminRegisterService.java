package com.mak.shop.serverusers.service;
import com.mak.shop.serverusers.dao.AdminRegisterDao;
import com.mak.shop.serverusers.entity.AdminUsers;

public class AdminRegisterService {

	AdminRegisterDao adminRegisterDao;
	
	public AdminRegisterService() {
		this.adminRegisterDao  = new AdminRegisterDao();
	}
	
	public int addUser(AdminUsers adminUsers) {
		this.adminRegisterDao.start();
		int userID = this.adminRegisterDao.adduser(adminUsers);
		this.adminRegisterDao.close();
		return userID;
		
	}
	
	public boolean checkUserNameEmail(String email) {
		
		boolean isAvailble =  this.adminRegisterDao.checkUserNameEmail(email);
		return isAvailble;
	}
	
}
