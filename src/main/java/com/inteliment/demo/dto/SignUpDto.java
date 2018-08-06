package com.inteliment.demo.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



public class SignUpDto {

	// private int userId;
	private String emailId;
	private String password;
	private String mobileNo;
	private String createdAt;
	private String deviceToken;

	// ------------------------ Getter and Setter
	// ----------------------------------

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	// ------------------------ Constructor ----------------------------------

	public SignUpDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUpDto(String emailId, String password, String mobileNo, String createdAt, String deviceToken) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.createdAt = createdAt;
		this.deviceToken = deviceToken;
	}

}
