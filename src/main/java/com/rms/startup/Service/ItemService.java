package com.rms.startup.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.ItemBean;
import com.rms.startup.DAO.ItemDAO;

@Service
public class ItemService {

	@Autowired
	ItemDAO itemDAO;

	public List<ItemBean> getAllItems() {
		return itemDAO.getAllItems();
	}
	
	
	public String addItem(ItemBean item){
		if(itemDAO.getItem(item.getItemId()) == null)
		{
			itemDAO.addItem(item);
			return Messages.added;
		}
		return Messages.alreadyExist;
			
	}
	
	public String updateItem(ItemBean item){
		System.out.println(item.getItemId());
		if(itemDAO.getItem(item.getItemId()) != null)
		{
			itemDAO.updateItem(item);
			return Messages.updated;
		}
		return Messages.doesNotExist;
	}
	
	public String deleteItem(Integer itemId){
		if(itemDAO.getItem(itemId) != null)
		{
			try{
				itemDAO.deleteItem(itemId);
			}
			catch(Exception e){
				return Messages.error;
			}
			return Messages.deleted;
		}
		return Messages.doesNotExist;
	}
	
	public ItemBean getItem(Integer itemId)
	{
		return itemDAO.getItem(itemId);
	}
	

	public List<ItemBean> findByCategoryCategoryId(Integer categoryId)
	{
		return itemDAO.findByCategoryId(categoryId);
	}
	
}