package com.rms.startup.Bean;


public class UserBean {
	private String mobileNumber;
	private String password;
	private UserTypeBean userType;
	private String userName;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserTypeBean getUserType() {
		return userType;
	}
	@Override
	public String toString() {
		return "UserBean [mobileNumber=" + mobileNumber + ", password=" + password + ", userType=" + userType + "]";
	}
	public void setUserType(UserTypeBean userType) {
		this.userType = userType;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
