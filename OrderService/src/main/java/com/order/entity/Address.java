package com.order.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	private int addressId;
	private String city;
	private String country;
	private int pin;
	@OneToOne(mappedBy = "address")
	private Order order;
	@OneToOne(mappedBy = "address")
	private OrderLine orderline;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderLine getOrderline() {
		return orderline;
	}
	public void setOrderline(OrderLine orderline) {
		this.orderline = orderline;
	}
}
	