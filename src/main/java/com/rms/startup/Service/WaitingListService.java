package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.CustomerBean;
import com.rms.startup.Bean.WaitingListBean;
import com.rms.startup.DAO.WaitingListDAO;

@Service
public class WaitingListService {

	@Autowired
	WaitingListDAO dao;

	@Autowired
	CustomerService customerService;

	public List<WaitingListBean> getAllWaitingList() {
		return dao.getAllWaitingList();
	}

	public String addWaitingList(WaitingListBean bean) {
		CustomerBean customerBean;
		if(customerService.getCustomer(bean.getCustomerBean().getMobileNumber()) != null) {
			customerBean = customerService.getCustomer(bean.getCustomerBean().getMobileNumber());	
		}
		else {
			customerBean = new CustomerBean();
			customerBean.setMobileNumber(bean.getCustomerBean().getMobileNumber());
			customerBean.setCustomerName(bean.getCustomerBean().getCustomerName());
			customerBean.setDob(bean.getCustomerBean().getDob());
			customerService.addCustomer(customerBean);
		}
		if (dao.findCustomer(customerBean).size() == 0) {
			dao.addWaitingList(bean);
			return Messages.added;
		}
		return Messages.alreadyExist;

	}

	public String deleteWaitingList(Integer waitingNumber) {
		dao.deleteWaitingList(waitingNumber);
		return Messages.deleted;
	}
	
	public int getWaitingNumber(String mobileNumber)
	{
		return dao.findCustomer(customerService.getCustomer(mobileNumber)).get(0).getWaitingNumber();
	}

	public WaitingListBean getWaitingList(Integer waitingNumber) {
		return dao.getWaitingList(waitingNumber);
	}

	public String updateWaitingList(WaitingListBean bean) {
		dao.updateWaitingList(bean);
		return Messages.updated;
	}

}
