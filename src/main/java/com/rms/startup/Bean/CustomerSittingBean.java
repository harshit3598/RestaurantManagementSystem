package com.rms.startup.Bean;

public class CustomerSittingBean{

	private int customerSittingId;
	private CustomerBean customer;
	private RestaurantTableBean restauranttable;


	public CustomerSittingBean() {
	}

	public int getCustomerSittingId() {
		return this.customerSittingId;
	}

	public void setCustomerSittingId(int customerSittingId) {
		this.customerSittingId = customerSittingId;
	}

	public CustomerBean getCustomer() {
		return this.customer;
	}

	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}

	public RestaurantTableBean getRestauranttable() {
		return this.restauranttable;
	}

	public void setRestauranttable(RestaurantTableBean restauranttable) {
		this.restauranttable = restauranttable;
	}


}

