package com.rms.startup.Bean;

import java.util.Date;


public class OrderBean {

	private String orderId;
	private Date orderDate;
	private float orderDiscount;
	private float orderTotal;
	private int isComplete;
	private CustomerSittingBean customersitting;
	
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getOrderDiscount() {
		return this.orderDiscount;
	}

	public void setOrderDiscount(float orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public float getOrderTotal() {
		return this.orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	public CustomerSittingBean getCustomersitting() {
		return this.customersitting;
	}

	public void setCustomersitting(CustomerSittingBean customersitting) {
		this.customersitting = customersitting;
	}

	public int getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(int isComplete) {
		this.isComplete = isComplete;
	}


}