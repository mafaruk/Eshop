package com.mak.shop.eshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mak.shop.eshop.entity.UserDetails;
import com.mak.shop.eshop.helper.SessionFactoryProvider;

public class LoginDao {

	Session hiberSession; 
	Transaction transaction;
	private UserDetails userDetails;

	
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public LoginDao() {
		hiberSession = SessionFactoryProvider.getSession();
		
	}
	public void start() {
		transaction = hiberSession.beginTransaction();
	}

	public boolean checkUserCreadential(String email, String Password) {
		boolean isAuthenticate = false;
		@SuppressWarnings("rawtypes")
		Query query = hiberSession
				.createQuery("from UserDetails u where u.userEmail = :user_email and u.userPassword = :pass_word");
		query.setParameter("user_email", email);
		query.setParameter("pass_word", Password);
		@SuppressWarnings("unchecked")
		List<UserDetails> userDetails = query.list();
		if ((userDetails.size() == 1) && (userDetails.get(0).getUserEmail().equals(email))
				&& (userDetails.get(0).getUserPassword().equals(Password))) {
			isAuthenticate = true;
			this.setUserDetails(userDetails.get(0));
		} else {

			isAuthenticate = false;
		}
		return isAuthenticate;

	}
	
	public void close() {
		this.transaction.commit();
	}

}
