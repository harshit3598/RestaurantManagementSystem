package com.rms.startup.Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rms.startup.Bean.CategoryBean;

@Entity
@Table(name="category")
public class CategoryEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4656458015403299999L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="categoryid")
	private Integer categoryId;
	@Column(name="categoryname")
	private String categoryName;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "category")
	private Set<ItemEntity> items;
	public Set<ItemEntity> getItems() {
		return items;
	}
	public void setItems(Set<ItemEntity> items) {
		this.items = items;
	}
	public CategoryEntity() {
	}
	public CategoryEntity(CategoryBean bean)
	{
		this.categoryId = bean.getCategoryId();
		this.categoryName = bean.getCategoryName();
	}
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public CategoryBean convertToBean()
	{
		CategoryBean category = new CategoryBean();
		category.setCategoryId(this.categoryId);
		category.setCategoryName(this.categoryName);
		return category;
	}
	public ItemEntity addItem(ItemEntity item) {
		getItems().add(item);
		item.setCategory(this.convertToBean());

		return item;
	}

	public ItemEntity removeItem(ItemEntity item) {
		getItems().remove(item);
		item.setCategory(null);

		return item;
	}

	
	@Override
	public String toString() {
		return "CategoryBean [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
