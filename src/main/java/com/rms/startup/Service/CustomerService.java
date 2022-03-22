package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.CustomerBean;
import com.rms.startup.DAO.CustomerDAO;

@Service
public class CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	public List<CustomerBean> getAllCustomer() {
		return customerDAO.getAllCustomer();
	}

	public String addCustomer(CustomerBean bean) {
		if (customerDAO.customerExists(bean.getMobileNumber())) {
			return Messages.alreadyExist;
		}
		customerDAO.addCustomer(bean);
		return Messages.added;
	}

	public String deleteCustomer(String mobileNumber) {
		if (customerDAO.customerExists(mobileNumber)) {
			customerDAO.deleteCustomer(mobileNumber);
			return Messages.deleted;
		}
		return Messages.notDeleted;

	}

	public CustomerBean getCustomer(String mobileNumber) {
		if(customerDAO.customerExists(mobileNumber))
			return customerDAO.getCustomer(mobileNumber);
		else
			return null;
	}

	public String updateCustomer(String mobileNumber, CustomerBean bean) {
		
		if(customerDAO.customerExists(mobileNumber))
		{
			customerDAO.updateCustomer(mobileNumber, bean);
			return Messages.updated;
		}
		return Messages.notUpdated;	
	}

}
