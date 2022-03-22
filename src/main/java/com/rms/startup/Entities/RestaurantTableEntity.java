package com.rms.startup.Entities;
import java.io.Serializable;
import javax.persistence.*;

import com.rms.startup.Bean.RestaurantTableBean;

import java.util.List;


/**
 * The persistent class for the restauranttable database table.
 * 
 */
@Entity
@Table(name="restauranttable")
public class RestaurantTableEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="tableid")
	private int tableId;

	@Column(name="occupied")
	private byte occupied;

	@Column(name="tablecapacity")
	private int tableCapacity;

	//bi-directional many-to-one association to Customersitting
	@OneToMany(mappedBy="restauranttable")
	private List<CustomerSittingEntity> customersittings;

	public RestaurantTableEntity() {
	}
	
	public RestaurantTableEntity(RestaurantTableBean bean) {
		this.tableId = bean.getTableId();
		this.tableCapacity = bean.getTableCapacity();
		this.occupied = bean.getOccupied();
	}
	
	public RestaurantTableBean convertToBean()
	{
		RestaurantTableBean bean = new RestaurantTableBean();
		bean.setTableId(this.tableId);
		bean.setTableCapacity(this.tableCapacity);
		bean.setOccupied(this.occupied);
		return bean;
	}


	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public byte getOccupied() {
		return this.occupied;
	}

	public void setOccupied(byte occupied) {
		this.occupied = occupied;
	}

	public int getTableCapacity() {
		return this.tableCapacity;
	}

	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}

	public List<CustomerSittingEntity> getCustomersittings() {
		return this.customersittings;
	}

	public void setCustomersittings(List<CustomerSittingEntity> customersittings) {
		this.customersittings = customersittings;
	}

	public CustomerSittingEntity addCustomersitting(CustomerSittingEntity customersitting) {
		getCustomersittings().add(customersitting);
		customersitting.setRestauranttable(this);

		return customersitting;
	}

	public CustomerSittingEntity removeCustomersitting(CustomerSittingEntity customersitting) {
		getCustomersittings().remove(customersitting);
		customersitting.setRestauranttable(null);

		return customersitting;
	}

}
