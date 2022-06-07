package com.order.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderLine {
	@Id
	private int orderlineId;
	private String item;
	private float price;
	private int quantity;
	private int eta;
	private OrderLineStatus orderLineStatus;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	private Order order;
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public OrderLineStatus getOrderLineStatus() {
		return orderLineStatus;
	}
	public void setOrderLineStatus(OrderLineStatus orderLineStatus) {
		this.orderLineStatus = orderLineStatus;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getOrderlineId() {
		return orderlineId;
	}
	public void setOrderlineId(int orderlineId) {
		this.orderlineId = orderlineId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
	