package com.rms.startup.Bean;

public class WaitingListBean {
	
	Integer waitingNumber;
	Integer numberOfPerson;
	CustomerBean customerBean;
	
	public Integer getWaitingNumber() {
		return waitingNumber;
	}
	public void setWaitingNumber(Integer waitingNumber) {
		this.waitingNumber = waitingNumber;
	}
	public Integer getNumberOfPerson() {
		return numberOfPerson;
	}
	public void setNumberOfPerson(Integer numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}
	public CustomerBean getCustomerBean() {
		return customerBean;
	}
	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}
	@Override
	public String toString() {
		return "WaitingListBean [waitingNumber=" + waitingNumber + ", numberOfPerson=" + numberOfPerson
				+ ", customerBean=" + customerBean + "]";
	}
 	
}
