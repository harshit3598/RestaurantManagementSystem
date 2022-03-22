package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.rms.startup.Bean.UserBean;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mobilenumber")
	private String mobileNumber;

	@Column(name="password")
	private String password;

	@Column(name="username")
	private String userName;
	//bi-directional many-to-one association to Usertype
	@ManyToOne
	@JoinColumn(name="usertype")
	private UserTypeEntity usertype;
	

	public UserEntity() {
	}
	
	public UserEntity(UserBean bean) {
		this.setMobileNumber(bean.getMobileNumber());
		this.setPassword(bean.getPassword());
		this.setUserName(bean.getUserName());
		this.setUsertype(new UserTypeEntity(bean.getUserType()));
	}


	public UserBean convertToBean()
	{
		UserBean bean = new UserBean();
		bean.setMobileNumber(this.mobileNumber);
		bean.setPassword(this.password);
		bean.setUserName(this.userName);
		bean.setUserType(this.usertype.convertToBean());
		return bean;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserTypeEntity getUsertype() {
		return this.usertype;
	}

	public void setUsertype(UserTypeEntity usertype) {
		this.usertype = usertype;
	}

}