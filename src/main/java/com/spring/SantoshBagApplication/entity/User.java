package com.spring.SantoshBagApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phonenumber")
	private String phoneNumber;
	
	@Column(name="email_id")
	private String emailId;
	
	public User() {
		
	}

	

	public User(int id, String name, String phoneNumber, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "User [userId=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ "]";
	}	
	
}
