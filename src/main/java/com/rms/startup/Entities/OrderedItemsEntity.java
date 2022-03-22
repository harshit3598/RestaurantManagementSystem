package com.rms.startup.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rms.startup.Bean.OrderedItemsBean;



@Entity
@Table(name="ordereditems")
public class OrderedItemsEntity implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="ordereditemsid")
	private Integer orderedItemsId;
	
	@Column(name="instruction")
	private String instruction;

	@Column(name="quantity")
	private int quantity;

	@Column(name="status")
	private int status;

	@ManyToOne
	@JoinColumn(name="itemid")
	private ItemEntity item;


	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderid")
	private OrderEntity order;
	

	public OrderedItemsEntity() {
	}

	public OrderedItemsEntity(OrderedItemsBean bean) {
		this.orderedItemsId = bean.getOrderedItemsId();
		this.order = new OrderEntity(bean.getOrder());
		this.item = new ItemEntity(bean.getItem());
		this.instruction = bean.getInstruction();
		this.quantity = bean.getQuantity();
		this.status = bean.getStatus();
	}

	
	public OrderedItemsBean convertToBean()
	{
		OrderedItemsBean bean = new OrderedItemsBean();
		bean.setInstruction(this.instruction);
		bean.setOrderedItemsId(this.orderedItemsId);
		bean.setQuantity(this.quantity);
		bean.setStatus(this.status);
		bean.setItem(this.item.convertToBean());
		bean.setOrder(this.order.convertToBean());
		return bean;
	}
	
	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setItem(ItemEntity item)
	{
		this.item = item;
	}
	public ItemEntity getItem()
	{
		return item;
	}
	public void setOrder(OrderEntity order)
	{
		this.order = order;
	}
	public OrderEntity getOrder()
	{
		return order;
	}

}
