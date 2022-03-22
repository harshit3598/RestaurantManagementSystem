package com.rms.startup.Bean;


public class RestaurantTableBean {
	
	private int tableId;
	private byte occupied;
	private int tableCapacity;
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public byte getOccupied() {
		return occupied;
	}
	public void setOccupied(byte occupied) {
		this.occupied = occupied;
	}
	public int getTableCapacity() {
		return tableCapacity;
	}
	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}


}
