package com.inteliment.demo.dto;

public class SignInDTO {

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignInDTO [userName=" + userName + ", password=" + password + "]";
	}

	public SignInDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public SignInDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
