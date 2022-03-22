package com.rms.startup.Service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.OrderBean;
import com.rms.startup.Bean.RestaurantTableBean;
import com.rms.startup.DAO.OrderDAO;

@Service
public class OrderService {

	@Autowired
	OrderDAO orderDAO;
	@Autowired
	RestaurantTableService restaurantTableService;
	@Autowired
	CustomerSittingService customerSittingService;

	public List<OrderBean> getAllOrders() {
		return orderDAO.getAllOrders();
	}
	
	
	public String addOrder(OrderBean order){
		if(orderDAO.getOrder(order.getOrderId()) == null)
		{
			orderDAO.addOrder(order);
			return Messages.added;
		}
		return Messages.alreadyExist;
			
	}
	
	public String updateOrder(OrderBean order){
		if(orderDAO.getOrder(order.getOrderId()) != null)
		{
			orderDAO.updateOrder(order);
			return Messages.updated;
		}
		return Messages.doesNotExist;
	}
	
	public String deleteOrder(String orderId){
		if(orderDAO.getOrder(orderId) != null)
		{
			try{
				orderDAO.deleteOrder(orderId);
			}
			catch(Exception e){
				return Messages.error;
			}
			return Messages.deleted;
		}
		return Messages.doesNotExist;
	}
	
	public OrderBean getOrder(String orderId)
	{
		return orderDAO.getOrder(orderId);
	}

	public void createOrder(Integer customerSittingId)
	{
		OrderBean order = new OrderBean();
		order.setOrderId("Order " + new Date().toString());
		order.setOrderId(order.getOrderId().replace(" ", "_"));
		order.setOrderDate(new Date());
		order.setCustomersitting(customerSittingService.getCustomerSitting(customerSittingId));
		order.setIsComplete(0);
		order.setOrderDiscount(0);
		order.setOrderTotal(0);
		addOrder(order);
	}
	
	public String completeOrder(String orderId)
	{
		OrderBean order = getOrder(orderId);
		order.setIsComplete(1);
		RestaurantTableBean table = order.getCustomersitting().getRestauranttable();
		table.setOccupied((byte)0);
		restaurantTableService.updateRestaurantTable(table);
		return updateOrder(order);
	}
	
	
	public String findByCustomerSittingId(Integer customerSittingId)
	{
		return orderDAO.findByCustomerSittingId(customerSittingId);
	}
	
	public List<OrderBean> getActiveOrders() {
		return orderDAO.getActiveOrders();
	}
	
	
}