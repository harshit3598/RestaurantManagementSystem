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

import com.rms.startup.Bean.UserTypeBean;
import com.rms.startup.Service.UserTypeService;

@RequestMapping("/userType")
@RestController
public class UserTypeController {

	@Autowired
	UserTypeService userTypeService;

	@GetMapping("/show")
	public List<UserTypeBean> showData() {
		return userTypeService.getAllUserTypes();
	}
	
	@PostMapping("/add")
	public String addUserType(@RequestBody UserTypeBean bean) {
		return userTypeService.addUserType(bean);
	}

	@GetMapping("/show/{userTypeId}")
	public UserTypeBean getUserType(@PathVariable Integer userTypeId) {
		return userTypeService.getUserType(userTypeId);
	}

	@DeleteMapping("/delete/{userTypeId}")
	public String deleteUserType(@PathVariable Integer userTypeId) {
		return userTypeService.deleteUserType(userTypeId);
	}

	@PutMapping("/update")
	public String updateUserType(@RequestBody UserTypeBean bean) {
		return userTypeService.updateUserType(bean);
	}
}
