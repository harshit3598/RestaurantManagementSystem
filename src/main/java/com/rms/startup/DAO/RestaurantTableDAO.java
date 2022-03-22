package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.RestaurantTableBean;
import com.rms.startup.DAO.JPA.RestaurantTableRepository;
import com.rms.startup.Entities.RestaurantTableEntity;

@Repository
public class RestaurantTableDAO {

	@Autowired
	RestaurantTableRepository repo;

	public List<RestaurantTableBean> getAllRestaurantTables() {
		List<RestaurantTableEntity> lst = repo.findAll();
		List<RestaurantTableBean> returnlst = new ArrayList<RestaurantTableBean>();
		for(RestaurantTableEntity RestaurantTable : lst)
			returnlst.add(RestaurantTable.convertToBean());
		return returnlst;
	}
	

	public List<RestaurantTableBean> getAllOccupiedRestaurantTables() {
		List<RestaurantTableEntity> lst = repo.findByOccupied((byte)1);
		List<RestaurantTableBean> returnlst = new ArrayList<RestaurantTableBean>();
		for(RestaurantTableEntity RestaurantTable : lst)
			returnlst.add(RestaurantTable.convertToBean());
		return returnlst;
	}
	
	public List<RestaurantTableBean> getAllAvailableRestaurantTables() {
		List<RestaurantTableEntity> lst = repo.findByOccupied((byte)0);
		List<RestaurantTableBean> returnlst = new ArrayList<RestaurantTableBean>();
		for(RestaurantTableEntity RestaurantTable : lst)
			returnlst.add(RestaurantTable.convertToBean());
		return returnlst;
	}
	

	
	public void addRestaurantTable(RestaurantTableBean restaurantTable)
	{
		repo.save(new RestaurantTableEntity(restaurantTable));
	}
	
	public void deleteRestaurantTable(Integer restaurantTableId)
	{
		repo.deleteById(restaurantTableId);
	}
	
	public void updateRestaurantTable(RestaurantTableBean restaurantTable)
	{
		repo.save(new RestaurantTableEntity(restaurantTable));
	}
	
	public RestaurantTableBean getRestaurantTable(Integer restaurantTableId)
	{
		if(repo.existsById(restaurantTableId))
			return repo.findById(restaurantTableId).get().convertToBean();
		return null;
	}
}