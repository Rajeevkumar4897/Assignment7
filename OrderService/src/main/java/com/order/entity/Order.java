package com.order.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Order {
	@Id
	private Integer orderId;
	private float totalAmount;
	private String orderDate;
	private OrderStatus orderStatus;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLine> orderlines;
	
	
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<OrderLine> getOrderlines() {
		return orderlines;
	}
	public void setOrderlines(List<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}
	
}
	