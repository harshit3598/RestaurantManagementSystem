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

import com.rms.startup.Bean.CustomerSittingBean;
import com.rms.startup.Service.CustomerSittingService;

@RequestMapping("/customerSitting")
@RestController
public class CustomerSittingController {

	@Autowired
	CustomerSittingService customerSittingService;

	@GetMapping("/show")
	public List<CustomerSittingBean> showData() {
		return customerSittingService.getAllCustomerSittings();
	}
	
	@PostMapping("/add")
	public String addCustomerSitting(@RequestBody CustomerSittingBean bean) {
		return customerSittingService.addCustomerSitting(bean);
	}

	@GetMapping("/show/{customerSittingId}")
	public CustomerSittingBean getCustomerSitting(@PathVariable Integer customerSittingId) {
		return customerSittingService.getCustomerSitting(customerSittingId);
	}

	@DeleteMapping("/delete/{customerSittingId}")
	public String deleteCustomerSitting(@PathVariable Integer customerSittingId) {
		return customerSittingService.deleteCustomerSitting(customerSittingId);
	}

	@PutMapping("/update")
	public String updateCustomerSitting(@RequestBody CustomerSittingBean bean) {
		return customerSittingService.updateCustomerSitting(bean);
	}
}
