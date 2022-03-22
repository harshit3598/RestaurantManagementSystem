package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.CustomerBean;
import com.rms.startup.DAO.JPA.CustomerRepository;
import com.rms.startup.Entities.CustomerEntity;

@Transactional
@Repository
public class CustomerDAO {

	@Autowired
	CustomerRepository repo;

	public List<CustomerBean> getAllCustomer() {
		List<CustomerEntity> lst = repo.findAll();
		List<CustomerBean> returnList = new ArrayList<CustomerBean>();
		for (CustomerEntity list : lst)
			returnList.add(list.convertToBean());
		return returnList;
	}

	public void addCustomer(CustomerBean bean) {
		CustomerEntity u = new CustomerEntity(bean);
		repo.save(u);
	}

	public void deleteCustomer(String mobileNumber) {
		// jdbcTemplate.update("delete from user where MobileNumber=?", mobileNumber);
		repo.deleteById(mobileNumber);
	}

	public CustomerBean getCustomer(String mobileNumber) {
		return repo.findById(mobileNumber).get().convertToBean();
	}

	public void updateCustomer(String mobileNumber, CustomerBean bean) {
		// jdbcTemplate.update("update User set MobileNumber=?,password=?,UserType=?
		// where MobileNumber=?",
		// bean.getMobileNumber(), bean.getPassword(), bean.getUserType(),
		// mobileNumber);
		repo.save(new CustomerEntity(bean));
	}

	public boolean customerExists(String mobileNumber) {
		if (repo.existsById(mobileNumber))
			return true;
		return false;
	}

}
