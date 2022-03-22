package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.CustomerSittingBean;
import com.rms.startup.DAO.JPA.CustomerSittingRepository;
import com.rms.startup.Entities.CustomerSittingEntity;

@Repository
public class CustomerSittingDAO {

	@Autowired
	CustomerSittingRepository repo;

	public List<CustomerSittingBean> getAllCustomerSittings() {
		List<CustomerSittingEntity> lst = repo.findAll();
		List<CustomerSittingBean> returnlst = new ArrayList<CustomerSittingBean>();
		for(CustomerSittingEntity CustomerSitting : lst)
			returnlst.add(CustomerSitting.convertToBean());
		return returnlst;
	}
	
	public void addCustomerSitting(CustomerSittingBean customerSitting)
	{
		repo.save(new CustomerSittingEntity(customerSitting));
	}
	
	public void deleteCustomerSitting(Integer customerSittingId)
	{
		repo.deleteById(customerSittingId);
	}
	
	public void updateCustomerSitting(CustomerSittingBean customerSitting)
	{
		repo.save(new CustomerSittingEntity(customerSitting));
	}
	
	public CustomerSittingBean getCustomerSitting(Integer customerSittingId)
	{
		if(repo.existsById(customerSittingId))
			return repo.findById(customerSittingId).get().convertToBean();
		return null;
	}
	
	public Integer findByTableId(Integer tableId)
	{
		return repo.findTable(tableId).get(0);
	}
	
}