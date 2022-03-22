package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.OrderedItemsBean;
import com.rms.startup.DAO.JPA.OrderedItemsRepository;
import com.rms.startup.Entities.OrderedItemsEntity;

@Repository
public class OrderedItemsDAO {

	@Autowired
	OrderedItemsRepository repo;

	public List<OrderedItemsBean> getAllOrderedItemss() {
		List<OrderedItemsEntity> lst = repo.findAll();
		List<OrderedItemsBean> returnlst = new ArrayList<OrderedItemsBean>();
		for(OrderedItemsEntity OrderedItems : lst)
			returnlst.add(OrderedItems.convertToBean());
		return returnlst;
	}
	
	public boolean isExist(Integer orderedItemsId)
	{
		return repo.existsById(orderedItemsId);
	}
	
	
	public void addOrderedItems(OrderedItemsBean orderedItems)
	{
		repo.save(new OrderedItemsEntity(orderedItems));
	}
	
	public void deleteOrderedItems(Integer orderedItemsId)
	{
		repo.deleteById(orderedItemsId);
	}
	
	public void updateOrderedItems(OrderedItemsBean orderedItems)
	{
		repo.save(new OrderedItemsEntity(orderedItems));
	}
	
	public OrderedItemsBean getOrderedItems(Integer orderedItemsId)
	{
		if(repo.existsById(orderedItemsId))
			return repo.findById(orderedItemsId).get().convertToBean();
		return null;
	}
	
	public List<OrderedItemsBean> getPendingOrders()
	{
		List<OrderedItemsEntity> lst = repo.findByStatus(0);
		List<OrderedItemsBean> returnlst = new ArrayList<OrderedItemsBean>();
		for(OrderedItemsEntity OrderedItems : lst)
			returnlst.add(OrderedItems.convertToBean());
		return returnlst;
		
	}
	
	
	public List<OrderedItemsBean> findByOrderId(String orderId)
	{
		List<OrderedItemsEntity> lst = repo.findOrder(orderId);
		List<OrderedItemsBean> returnlst = new ArrayList<OrderedItemsBean>();
		for(OrderedItemsEntity OrderedItems : lst)
			returnlst.add(OrderedItems.convertToBean());
		return returnlst;
		
	}
	
	
}