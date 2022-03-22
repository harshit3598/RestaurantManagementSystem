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

import com.rms.startup.Bean.CategoryBean;
import com.rms.startup.Service.CategoryService;

@RequestMapping("/category")
@RestController
public class CategoryController {

	@Autowired
	CategoryService CategoryService;

	@GetMapping("/show")
	public List<CategoryBean> showData() {
		return CategoryService.getAllCategory();
	}

	@PostMapping("/add")
	public String addCategory(@RequestBody CategoryBean bean) {
		return CategoryService.addCategory(bean);
	}

	@GetMapping("/show/{categoryId}")
	public CategoryBean getCategory(@PathVariable Integer categoryId) {
		return CategoryService.getCategory(categoryId);
	}

	@DeleteMapping("/delete/{categoryId}")
	public String deleteCategory(@PathVariable Integer categoryId) {
		return CategoryService.deleteCategory(categoryId);
	}

	@PutMapping("/update")
	public String updateCategory(@RequestBody CategoryBean bean) {
		return CategoryService.updateCategory(bean);
	}

}
