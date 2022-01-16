package com.mak.shop.eshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mak.shop.eshop.entity.UserDetails;
import com.mak.shop.eshop.helper.SessionFactoryProvider;

public class RegisterDao {

	Session hiberSession; 
	Transaction transaction;
	
	

	public RegisterDao() {
		this.hiberSession = SessionFactoryProvider.getSession();
	}

	public void start() {
		this.transaction = hiberSession.beginTransaction();
	}
	
	public int adduser(UserDetails userDetails) {
		int userID = 0;
		userID = (int) hiberSession.save(userDetails);
		return userID;
	}
	
	public boolean checkUserNameEmail(String email) {
		boolean isAvailable = false;
		@SuppressWarnings("rawtypes")
		Query query = hiberSession
				.createQuery("from UserDetails u where u.userEmail = :email");
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<UserDetails> userDetails = query.list();
		if ((userDetails.size() == 1) && (userDetails.get(0).getUserEmail().equals(email))) {
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
