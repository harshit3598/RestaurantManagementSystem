package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.CategoryBean;
import com.rms.startup.DAO.JPA.CategoryRepository;
import com.rms.startup.Entities.CategoryEntity;

@Repository
public class CategoryDAO {

	@Autowired
	CategoryRepository repo;

	public List<CategoryBean> getAllCategory() {
		List<CategoryEntity> lst = repo.findAll();
		List<CategoryBean> returnlst = new ArrayList<CategoryBean>();
		for(CategoryEntity category : lst)
			returnlst.add(category.convertToBean());
		return returnlst;
	}

	public void addCategory(CategoryBean bean) {
		CategoryEntity category = new CategoryEntity(bean);
		repo.save(category);
	}

	public void deleteCategory(Integer categoryId) throws Exception{
		repo.deleteById(categoryId);
	}

	public CategoryBean getCategory(Integer categoryId) {
		if(repo.existsById(categoryId))
			return repo.findById(categoryId).get().convertToBean();
		return null;
	}

	public void updateCategory(CategoryBean bean) {
		repo.save(new CategoryEntity(bean));
	}

}
