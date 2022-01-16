package com.mak.shop.eshop.helper;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
	private static Session factory;
	
	public static Session getSession() {
		
		if(factory==null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		}
		
		return factory;
		
	}
	
}
