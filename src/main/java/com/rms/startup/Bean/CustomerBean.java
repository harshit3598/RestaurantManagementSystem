package com.rms.startup.Bean;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerBean {

	String mobileNumber;
	String customerName;
	@JsonFormat(pattern="dd-MM-yyyy")
	Date dob;

	@Override
	public String toString() {
		return "CustomerBean [mobileNumber=" + mobileNumber + ", customerName=" + customerName + ", DOB=" + dob + "]";
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
