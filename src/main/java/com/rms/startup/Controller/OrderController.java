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

import com.rms.startup.Bean.OrderBean;
import com.rms.startup.Service.OrderService;

@RequestMapping("/order")
@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("/show")
	public List<OrderBean> showData() {
		return orderService.getAllOrders();
	}
	
	@PostMapping("/add")
	public String addOrder(@RequestBody OrderBean bean) {
		return orderService.addOrder(bean);
	}

	@GetMapping("/show/{orderId}")
	public OrderBean getOrder(@PathVariable String orderId) {
		return orderService.getOrder(orderId);
	}

	@GetMapping("/active")
	public List<OrderBean> getActiveOrder() {
		return orderService.getActiveOrders();
	}
	
	@DeleteMapping("/delete/{orderId}")
	public String deleteOrder(@PathVariable String orderId) {
		return orderService.deleteOrder(orderId);
	}

	@PutMapping("/update")
	public String updateOrder(@RequestBody OrderBean bean) {
		return orderService.updateOrder(bean);
	}
	
	@PutMapping("/update/complete/{orderId}")
	public String completeOrder(@PathVariable String orderId) {
		return orderService.completeOrder(orderId);
	}
	
}
