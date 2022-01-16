package com.mak.shop.serverusers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mak.shop.eshop.helper.SessionFactoryProvider;
import com.mak.shop.serverusers.entity.AdminUsers;

public class AdminRegisterDao {
	Session hiberSession; 
	Transaction transaction;
	
	

	public AdminRegisterDao() {
		this.hiberSession = SessionFactoryProvider.getSession();
	}

	public void start() {
		this.transaction = hiberSession.beginTransaction();
	}
	
	public int adduser(AdminUsers adminUsers) {
		int userID = 0;
		userID = (int) hiberSession.save(adminUsers);
		return userID;
	}
	
	public boolean checkUserNameEmail(String email) {
		boolean isAvailable = false;
		@SuppressWarnings("rawtypes")
		Query query = hiberSession
				.createQuery("from AdminUsers u where u.userEmail = :email");
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<AdminUsers> adminUsers = query.list();
		if ((adminUsers.size() == 1) && (adminUsers.get(0).getUserEmail().equals(email))) {
			isAvailable = true;
		} else {
			isAvailable = false;
		}
		return isAvailable;
	}
	
	public void close() {
		this.transaction.commit();
	}
}
