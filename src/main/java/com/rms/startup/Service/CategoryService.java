package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.CategoryBean;
import com.rms.startup.DAO.CategoryDAO;

@Service
public class CategoryService {

	@Autowired
	CategoryDAO CategoryDAO;

	public List<CategoryBean> getAllCategory() {
		return CategoryDAO.getAllCategory();
	}

	public String addCategory(CategoryBean bean) {
		if(CategoryDAO.getCategory(bean.getCategoryId()) == null)
		{
			CategoryDAO.addCategory(bean);
			return Messages.added;
		}
		return Messages.alreadyExist;
	}

	public String deleteCategory(Integer categoryId) {
		if(CategoryDAO.getCategory(categoryId) != null)
		{
				try {
			CategoryDAO.deleteCategory(categoryId);
			return Messages.deleted;
			} catch (Exception e) {
				return Messages.itemExistError; 
			}
		}
		else
			return Messages.doesNotExist;
	}

	public CategoryBean getCategory(Integer categoryId) {
		return CategoryDAO.getCategory(categoryId);
	}

	public String updateCategory(CategoryBean bean) {
		if(CategoryDAO.getCategory(bean.getCategoryId()) != null)
		{
			CategoryDAO.updateCategory(bean);
			return Messages.updated;
		}
		return Messages.doesNotExist;
	}

}
