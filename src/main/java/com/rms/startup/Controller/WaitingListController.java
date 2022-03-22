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

import com.rms.startup.Bean.WaitingListBean;
import com.rms.startup.Service.WaitingListService;

@RequestMapping("/waiting")
@RestController
public class WaitingListController {

	@Autowired
	WaitingListService service;

	@GetMapping("/show")
	public List<WaitingListBean> getAllWaitingList() {
		return service.getAllWaitingList();
	}

	@PostMapping("/add")
	public String addWaitingList(@RequestBody WaitingListBean bean) {
		return service.addWaitingList(bean);
	}

	@DeleteMapping("/delete/{waitingNumber}")
	public String deleteWaitingList(@PathVariable Integer waitingNumber) {
		return service.deleteWaitingList(waitingNumber);
	}

	@GetMapping("/show/{waitingNumber}")
	public WaitingListBean getWaitingList(@PathVariable Integer waitingNumber) {
		return service.getWaitingList(waitingNumber);
	}

	@PutMapping("/update")
	public String updateWaitingList(@RequestBody WaitingListBean bean) {
		return service.updateWaitingList(bean);
	}
}
