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

import com.rms.startup.Bean.UserBean;
import com.rms.startup.Service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/show")
	public List<UserBean> showData()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("/type/{userTypeId}")
	public List<UserBean> getByUserType(@PathVariable Integer userTypeId)
	{
		return userService.getByUserType(userTypeId);
	}

	@PostMapping("/add")
	public String addUser(@RequestBody UserBean bean)
	{
		return userService.addUser(bean);
	}
	
	@GetMapping("/show/{mobileNumber}")
	public UserBean getuser(@PathVariable String mobileNumber)
	{
		return userService.getUser(mobileNumber);
	}
	
	@DeleteMapping("/delete/{mobileNumber}")
	public String deleteUser(@PathVariable String mobileNumber)
	{
		return userService.deleteUser(mobileNumber);
	}
	
	@PutMapping("/update/{mobileNumber}")
	public String updateUser(@RequestBody UserBean bean,@PathVariable String mobileNumber)
	{
		return userService.updateUser(mobileNumber,bean);
	}
	
	@PostMapping("/loginweb")
	public String logIn(@RequestBody UserBean bean)
	{
		if(userService.validateUser(bean))
			return "Success";
		else
			return "Fail";
	}
	
	@PostMapping("/login")
	public String logIn(@RequestParam String mobileNumber,@RequestParam String password)
	{
		if(userService.validateUser(mobileNumber,password))
			return "success";
		else
			return "Fail";
	}
	
	
//	@GetMapping("/logInList")
//	public List<Map<String, Object>> show()
//	{
//		//return jdbcObject.queryForList("select * from User;");
//	}
}
