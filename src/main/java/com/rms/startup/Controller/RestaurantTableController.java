package com.rms.startup.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.startup.Bean.RestaurantTableBean;
import com.rms.startup.Service.RestaurantTableService;

@RequestMapping("/restaurantTable")
@RestController
public class RestaurantTableController {

	@Autowired
	RestaurantTableService restaurantTableService;

	@GetMapping("/show")
	public List<RestaurantTableBean> showData() {
		return restaurantTableService.getAllRestaurantTables();
	}
	
	@PostMapping("/add")
	public String addRestaurantTable(@RequestBody RestaurantTableBean bean) {
		return restaurantTableService.addRestaurantTable(bean);
	}
	
	@GetMapping("/show/occupied")
	public List<RestaurantTableBean> getOccupiedTables() {
		return restaurantTableService.getAllOccupiedRestaurantTables();
	}
	
	@GetMapping("/show/available")
	public List<RestaurantTableBean> getAvailableTables() {
		return restaurantTableService.getAllAvailableRestaurantTables();
	}

	@GetMapping("/show/{restaurantTableId}")
	public RestaurantTableBean getRestaurantTable(@PathVariable Integer restaurantTableId) {
		return restaurantTableService.getRestaurantTable(restaurantTableId);
	}

	@DeleteMapping("/delete/{restaurantTableId}")
	public String deleteRestaurantTable(@PathVariable Integer restaurantTableId) {
		return restaurantTableService.deleteRestaurantTable(restaurantTableId);
	}

	@PutMapping("/update")
	public String updateRestaurantTable(@RequestBody RestaurantTableBean bean) {
		return restaurantTableService.updateRestaurantTable(bean);
	}
}
