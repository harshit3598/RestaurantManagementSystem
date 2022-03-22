package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.OrderBean;
import com.rms.startup.DAO.JPA.OrderRepository;
import com.rms.startup.Entities.OrderEntity;

@Repository
public class OrderDAO {

	@Autowired
	OrderRepository repo;

	public List<OrderBean> getAllOrders() {
		List<OrderEntity> lst = repo.findAll();
		List<OrderBean> returnlst = new ArrayList<OrderBean>();
		for(OrderEntity Order : lst)
			returnlst.add(Order.convertToBean());
		return returnlst;
	}
	
	public void addOrder(OrderBean order)
	{
		repo.save(new OrderEntity(order));
	}
	
	public void deleteOrder(String orderId)
	{
		repo.deleteById(orderId);
	}
	
	public void updateOrder(OrderBean order)
	{
		repo.save(new OrderEntity(order));
	}
	
	public OrderBean getOrder(String orderId)
	{
		if(repo.existsById(orderId))
			return repo.findById(orderId).get().convertToBean();
		return null;
	}
	
	public List<OrderBean> getActiveOrders() {
		List<OrderEntity> lst = repo.findByIsComplete(0);
		List<OrderBean> returnlst = new ArrayList<OrderBean>();
		for(OrderEntity Order : lst)
			returnlst.add(Order.convertToBean());
		return returnlst;
	}
	
	public String findByCustomerSittingId(Integer customerSittingId)
	{
		return repo.findCustomerSitting(customerSittingId);
	}
	
}