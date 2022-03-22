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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rms.startup.Bean.OrderedItemsBean;
import com.rms.startup.Service.OrderedItemsService;

@RequestMapping("/orderedItems")
@RestController
public class OrderedItemsController {

	@Autowired
	OrderedItemsService orderedItemsService;

	@GetMapping("/show")
	public List<OrderedItemsBean> showData() {
		return orderedItemsService.getAllOrderedItemss();
	}

	@PostMapping("/add")
	public String addOrderedItems(@RequestBody OrderedItemsBean bean) {
		return orderedItemsService.addOrderedItems(bean);
	}

	@PutMapping("/update/quantity")
	public String updateQuantity(@RequestParam String orderedItemsId, @RequestParam String quantity) {
		return orderedItemsService.updateQuantity(Integer.parseInt(orderedItemsId), Integer.parseInt(quantity));
	}

	@GetMapping("/show/{orderedItemsId}")
	public OrderedItemsBean getOrderedItems(@PathVariable Integer orderedItemsId) {
		return orderedItemsService.getOrderedItems(orderedItemsId);
	}

	@DeleteMapping("/delete/{orderedItemsId}")
	public String deleteOrderedItems(@PathVariable Integer orderedItemsId) {
		return orderedItemsService.deleteOrderedItems(orderedItemsId);
	}

	@PutMapping("/update/complete/{orderedItemsId}")
	public String changeStatus(@PathVariable Integer orderedItemsId) {
		return orderedItemsService.changeStatus(orderedItemsId);
	}
	
	@GetMapping("/order/details/{orderId}")
	public List<OrderedItemsBean> viewOrderByOrderId(@PathVariable String orderId) {
		return orderedItemsService.findByOrderId(orderId);
	}
	
	@GetMapping("/show/pending")
	public List<OrderedItemsBean> getPendingOrders() {
		return orderedItemsService.getPendingOrders();
	}
	

	@GetMapping("/order/{tableId}")
	public List<OrderedItemsBean> viewOrder(@PathVariable Integer tableId) {
		return orderedItemsService.findByTableId(tableId);
	}

	@PostMapping("/items/add")
	public String addOrderedItems(@RequestParam String tableId, @RequestParam String quantity,
			@RequestParam String itemId, @RequestParam String instruction) {
		return orderedItemsService.addOrderedItems(Integer.parseInt(tableId), Integer.parseInt(quantity),
				Integer.parseInt(itemId), instruction);
	}

}
