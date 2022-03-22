package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.rms.startup.Bean.OrderBean;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="orderdetail")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="orderid")
	private String orderId;

	@Temporal(TemporalType.DATE)
	@Column(name="orderdate")
	private Date orderDate;

	@Column(name="orderdiscount")
	private float orderDiscount;

	@Column(name="ordertotal")
	private float orderTotal;
	
	@Column(name="iscomplete")
	private int isComplete;

	//bi-directional many-to-one association to Customersitting
	@ManyToOne
	@JoinColumn(name="customersittingid")
	private CustomerSittingEntity customersitting;

	//bi-directional many-to-one association to Ordereditem
	@OneToMany(mappedBy="order")
	private List<OrderedItemsEntity> ordereditems;

	public OrderEntity() {
	}
	
	public OrderEntity(OrderBean bean)
	{
		this.orderId = bean.getOrderId();
		this.orderDate = bean.getOrderDate();
		this.orderDiscount = bean.getOrderDiscount();
		this.orderTotal = bean.getOrderTotal();
		this.customersitting = new CustomerSittingEntity(bean.getCustomersitting());
		this.isComplete = bean.getIsComplete();
	}
	
	public OrderBean convertToBean()
	{
		OrderBean bean = new OrderBean();
		bean.setOrderId(this.orderId);
		bean.setOrderDate(this.orderDate);
		bean.setOrderDiscount(this.orderDiscount);
		bean.setOrderTotal(this.orderTotal);
		bean.setCustomersitting(this.customersitting.convertToBean());
		bean.setIsComplete(this.isComplete);
		return bean;
		
	}
	
	public int getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(int isComplete) {
		this.isComplete = isComplete;
	}


	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getOrderDiscount() {
		return this.orderDiscount;
	}

	public void setOrderDiscount(float orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public float getOrderTotal() {
		return this.orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}


	public CustomerSittingEntity getCustomersitting() {
		return customersitting;
	}

	public void setCustomersitting(CustomerSittingEntity customersitting) {
		this.customersitting = customersitting;
	}

	public List<OrderedItemsEntity> getOrdereditems() {
		return ordereditems;
	}

	public void setOrdereditems(List<OrderedItemsEntity> ordereditems) {
		this.ordereditems = ordereditems;
	}

	public OrderedItemsEntity addOrdereditem(OrderedItemsEntity ordereditem) {
		getOrdereditems().add(ordereditem);
		ordereditem.setOrder(this);

		return ordereditem;
	}

	public OrderedItemsEntity removeOrdereditem(OrderedItemsEntity ordereditem) {
		getOrdereditems().remove(ordereditem);
		ordereditem.setOrder(null);

		return ordereditem;
	}

}