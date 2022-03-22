package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.ItemBean;
import com.rms.startup.DAO.JPA.ItemRepository;
import com.rms.startup.Entities.ItemEntity;

@Repository
public class ItemDAO {

	@Autowired
	ItemRepository repo;

	public List<ItemBean> getAllItems() {
		List<ItemEntity> lst = repo.findAll();
		List<ItemBean> returnlst = new ArrayList<ItemBean>();
		for(ItemEntity Item : lst)
			returnlst.add(Item.convertToBean());
		return returnlst;
	}
	
	public void addItem(ItemBean item)
	{
		repo.save(new ItemEntity(item));
	}
	
	public void deleteItem(Integer itemId)
	{
		repo.deleteById(itemId);
	}
	
	public void updateItem(ItemBean item)
	{
		repo.save(new ItemEntity(item));
	}
	
	public ItemBean getItem(Integer itemId)
	{
		if(repo.existsById(itemId))
			return repo.findById(itemId).get().convertToBean();
		return null;
	}
	
	public List<ItemBean> findByCategoryId(Integer categoryId)
	{
		List<ItemEntity> lst = repo.findByCategoryCategoryId(categoryId);
		List<ItemBean> returnlst = new ArrayList<ItemBean>();
		for(ItemEntity Item : lst)
			returnlst.add(Item.convertToBean());
		return returnlst;
	}
}