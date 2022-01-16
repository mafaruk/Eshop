package com.mak.shop.eshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

//@NamedQueries(  
//	    {  
//	        @NamedQuery(  
//	        name = "AuthenticateUser",  
//	        query = "from UserDetails u where u.userName = :user_name and u.userPassword = :pass_word"  
//	        )  
//	    }  
//	)


@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	private String userName;
	@Column(unique = true)
	private String userEmail;
	private String userPassword;
	private String userPhone;
	private String userPic;
	@OneToOne(cascade = CascadeType.ALL)
	private Address userAddressID;
	

	public UserDetails(String userName, String userEmail, String userPassword, String userPhone, String userPic,
			Address userAddressID) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userPic = userPic;
		this.userAddressID = userAddressID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public Address getUserAddressID() {
		return userAddressID;
	}

	public void setUserAddressID(Address userAddressID) {
		this.userAddressID = userAddressID;
	}

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
