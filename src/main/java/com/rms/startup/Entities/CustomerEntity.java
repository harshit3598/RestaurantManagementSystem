package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.rms.startup.Bean.CustomerBean;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="customer")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mobilenumber")
	private String mobileNumber;
	@Column(name="customername")
	private String customerName;

	@Temporal(TemporalType.DATE)
	@Column(name="dob")
	private Date dob;

	//bi-directional many-to-one association to CustomerSitting
	@OneToMany(mappedBy="customer")
	private List<CustomerSittingEntity> CustomerSittings;

	//bi-directional many-to-one association to Waitinglist
	@OneToMany(mappedBy="customer")
	private List<WaitingListEntity> waitinglists;

	public CustomerEntity() {
	}

	public CustomerEntity(CustomerBean bean) {
		// TODO Auto-generated constructor stub
		this.customerName = bean.getCustomerName();
		this.dob = bean.getDob();
		this.mobileNumber = bean.getMobileNumber();
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<CustomerSittingEntity> getCustomerSittings() {
		return this.CustomerSittings;
	}

	public void setCustomerSittings(List<CustomerSittingEntity> CustomerSittings) {
		this.CustomerSittings = CustomerSittings;
	}

	public CustomerSittingEntity addCustomerSitting(CustomerSittingEntity CustomerSitting) {
		getCustomerSittings().add(CustomerSitting);
		CustomerSitting.setCustomer(this);

		return CustomerSitting;
	}

	public CustomerSittingEntity removeCustomerSitting(CustomerSittingEntity CustomerSitting) {
		getCustomerSittings().remove(CustomerSitting);
		CustomerSitting.setCustomer(null);

		return CustomerSitting;
	}

	public List<WaitingListEntity> getWaitinglists() {
		return this.waitinglists;
	}

	public void setWaitinglists(List<WaitingListEntity> waitinglists) {
		this.waitinglists = waitinglists;
	}

	public WaitingListEntity addWaitinglist(WaitingListEntity waitinglist) {
		getWaitinglists().add(waitinglist);
		waitinglist.setCustomer(this);

		return waitinglist;
	}

	public WaitingListEntity removeWaitinglist(WaitingListEntity waitinglist) {
		getWaitinglists().remove(waitinglist);
		waitinglist.setCustomer(null);

		return waitinglist;
	}

	public CustomerBean convertToBean() {
		CustomerBean bean = new CustomerBean();
		bean.setCustomerName(this.getCustomerName());
		bean.setDob(this.getDob());
		bean.setMobileNumber(this.getMobileNumber());
		return bean;
	}

}
