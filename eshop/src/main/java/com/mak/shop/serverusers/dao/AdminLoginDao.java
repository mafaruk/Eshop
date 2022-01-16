package com.mak.shop.serverusers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mak.shop.eshop.helper.SessionFactoryProvider;
import com.mak.shop.serverusers.entity.AdminUsers;

public class AdminLoginDao {

	Session hiberSession; 
	Transaction transaction;
	private String userName;

	public AdminLoginDao() {
		hiberSession = SessionFactoryProvider.getSession();
		
	}

	public boolean checkUserCreadential(String email, String Password) {
		boolean isAuthenticate = false;
		@SuppressWarnings("rawtypes")
		Query query = hiberSession
				.createQuery("from AdminUsers u where u.userEmail = :user_email and u.userPassword = :pass_word");
		query.setParameter("user_email", email);
		query.setParameter("pass_word", Password);
		@SuppressWarnings("unchecked")
		List<AdminUsers> adminUserDetails = query.list();
		if ((adminUserDetails.size() == 1) && (adminUserDetails.get(0).getUserEmail().equals(email))
				&& (adminUserDetails.get(0).getUserPassword().equals(Password))) {
			isAuthenticate = true;
			this.setUserName(adminUserDetails.get(0).getUserName());
		} else {

			isAuthenticate = false;
		}
		return isAuthenticate;

	}
	
	public void start() {
		this.transaction = hiberSession.beginTransaction();
	}
	
	public void close() {
		this.transaction.commit();
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
