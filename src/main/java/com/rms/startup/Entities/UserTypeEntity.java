package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.rms.startup.Bean.UserTypeBean;

import java.util.List;


/**
 * The persistent class for the usertype database table.
 * 
 */
@Entity
@Table(name="usertype")
public class UserTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="usertypeid")
	private int userTypeId;

	@Column(name="usertypename")
	private String userTypeName;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="usertype")
	private List<UserEntity> users;

	public UserTypeEntity() {
	}

	public UserTypeEntity(UserTypeBean bean)
	{
		this.userTypeId = bean.getUserTypeId();
		this.userTypeName = bean.getUserTypeName();
	}
	
	public UserTypeBean convertToBean()
	{
		UserTypeBean bean = new UserTypeBean();
		bean.setUserTypeId(this.userTypeId);
		bean.setUserTypeName(this.userTypeName);
		return bean;
	}
	
	public int getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return this.userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public List<UserEntity> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public UserEntity addUser(UserEntity user) {
		getUsers().add(user);
		user.setUsertype(this);

		return user;
	}

	public UserEntity removeUser(UserEntity user) {
		getUsers().remove(user);
		user.setUsertype(null);

		return user;
	}

}