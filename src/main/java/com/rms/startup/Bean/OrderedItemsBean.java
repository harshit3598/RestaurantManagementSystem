package com.rms.startup.Bean;


public class OrderedItemsBean{

	private Integer orderedItemsId;
	private String instruction;
	private Integer quantity;
	private Integer status;
	private ItemBean item;
	private OrderBean order;
	

	public OrderedItemsBean() {
	}

	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setItem(ItemBean item)
	{
		this.item = item;
	}
	public ItemBean getItem()
	{
		return item;
	}
	public void setOrder(OrderBean order)
	{
		this.order = order;
	}
	public Integer getOrderedItemsId() {
		return orderedItemsId;
	}

	public void setOrderedItemsId(Integer orderedItemsId) {
		this.orderedItemsId = orderedItemsId;
	}

	public OrderBean getOrder()
	{
		return order;
	}

}
