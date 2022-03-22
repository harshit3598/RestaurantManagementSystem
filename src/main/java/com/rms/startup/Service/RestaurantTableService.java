package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.RestaurantTableBean;
import com.rms.startup.DAO.RestaurantTableDAO;

@Service
public class RestaurantTableService {

	@Autowired
	RestaurantTableDAO restaurantTableDAO;

	public List<RestaurantTableBean> getAllRestaurantTables() {
		return restaurantTableDAO.getAllRestaurantTables();
	}
	
	
	public List<RestaurantTableBean> getAllOccupiedRestaurantTables() {
		return restaurantTableDAO.getAllOccupiedRestaurantTables();
	}
	
	public List<RestaurantTableBean> getAllAvailableRestaurantTables() {
		return restaurantTableDAO.getAllAvailableRestaurantTables();
	}
	
	
	public String addRestaurantTable(RestaurantTableBean restaurantTable){
		if(restaurantTableDAO.getRestaurantTable(restaurantTable.getTableId()) == null)
		{
			restaurantTableDAO.addRestaurantTable(restaurantTable);
			return Messages.added;
		}
		return Messages.alreadyExist;
			
	}
	
	public String updateRestaurantTable(RestaurantTableBean restaurantTable){
		if(restaurantTableDAO.getRestaurantTable(restaurantTable.getTableId()) != null)
		{
			restaurantTableDAO.updateRestaurantTable(restaurantTable);
			return Messages.updated;
		}
		return Messages.doesNotExist;
	}
	
	public String deleteRestaurantTable(Integer restaurantTableId){
		if(restaurantTableDAO.getRestaurantTable(restaurantTableId) != null)
		{
			try{
				restaurantTableDAO.deleteRestaurantTable(restaurantTableId);
			}
			catch(Exception e){
				return Messages.error;
			}
			return Messages.deleted;
		}
		return Messages.doesNotExist;
	}
	
	public RestaurantTableBean getRestaurantTable(Integer restaurantTableId)
	{
		return restaurantTableDAO.getRestaurantTable(restaurantTableId);
	}
}