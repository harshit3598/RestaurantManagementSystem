package com.rms.startup.Entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rms.startup.Bean.CategoryBean;
import com.rms.startup.Bean.ItemBean;

@Entity
@Table(name="item")
public class ItemEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7558318717133885617L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="itemid")
	private Integer itemId;
	@Column(name="itemname")
	private String itemName;
	@Column(name="itemdescription")
	private String itemDescription;
	@Column(name="itemprice")
	private float itemPrice;
	@ManyToOne
	@JoinColumn(name="categoryid")
	private CategoryEntity category;
	
	public ItemEntity() {
		
	}
	
	public ItemEntity(ItemBean bean) {
		this.itemId = bean.getItemId();
		this.itemName = bean.getItemName();
		this.itemDescription = bean.getItemDescription();
		this.itemPrice = bean.getItemPrice();
		this.category = new CategoryEntity(bean.getCategory());
	}
	
	public List<OrderedItemsEntity> getOrdereditems() {
		return ordereditems;
	}
	public void setOrdereditems(List<OrderedItemsEntity> ordereditems) {
		this.ordereditems = ordereditems;
	}

	@OneToMany(mappedBy="item")
	private List<OrderedItemsEntity> ordereditems;

	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public CategoryBean getCategory() {
		return category.convertToBean();
	}
	public void setCategory(CategoryBean category) {
		this.category = new CategoryEntity(category);
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public ItemBean convertToBean()
	{
		ItemBean item = new ItemBean();
		item.setItemId(this.itemId);
		item.setItemName(this.itemName);
		item.setItemDescription(this.itemDescription);
		item.setItemPrice(this.itemPrice);
		item.setCategory(this.category.convertToBean());
		return item;
	}
	
	public OrderedItemsEntity addOrdereditem(OrderedItemsEntity ordereditem) {
		getOrdereditems().add(ordereditem);
		ordereditem.setItem(this);

		return ordereditem;
	}

	public OrderedItemsEntity removeOrdereditem(OrderedItemsEntity ordereditem) {
		getOrdereditems().remove(ordereditem);
		ordereditem.setItem(null);

		return ordereditem;
	}
	
}
