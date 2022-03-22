package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.rms.startup.Bean.WaitingListBean;

/**
 * The persistent class for the waitinglist database table.
 * 
 */
@Entity
@Table(name = "waitinglist")
public class WaitingListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "waitingnumber")
	private int waitingNumber;

	@Column(name = "numberofperson")
	private int numberOfPerson;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "mobilenumber")
	private CustomerEntity customer;

	@Override
	public String toString() {
		return "WaitingListEntity [waitingNumber=" + waitingNumber + ", numberOfPerson=" + numberOfPerson
				+ ", customer=" + customer + "]";
	}

	public WaitingListEntity() {
	}

	public int getWaitingNumber() {
		return this.waitingNumber;
	}

	public void setWaitingNumber(int waitingNumber) {
		this.waitingNumber = waitingNumber;
	}

	public int getNumberOfPerson() {
		return this.numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public CustomerEntity getCustomer() {
		return this.customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public WaitingListEntity(WaitingListBean bean) {
		this.numberOfPerson = bean.getNumberOfPerson();
		this.waitingNumber = bean.getWaitingNumber();
		this.customer = new CustomerEntity(bean.getCustomerBean());
	}

	public WaitingListBean convertToBean() {
		WaitingListBean bean = new WaitingListBean();
		bean.setCustomerBean(this.customer.convertToBean());
		bean.setNumberOfPerson(this.getNumberOfPerson());
		bean.setWaitingNumber(this.getWaitingNumber());
		return bean;
	}

}
