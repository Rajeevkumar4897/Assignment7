package com.order.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.entity.OrderLine;
import com.order.entity.OrderLineStatus;
import com.order.entity.OrderStatus;
import com.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	 private OrderRepository repo;
	
	public static float claculateFinalAmount(List<OrderLine> orderlines) {
		float totalAmount=1;
		for(OrderLine ol:orderlines) {
			totalAmount = totalAmount + (ol.getPrice() * ol.getQuantity()) ;
		}
		return totalAmount;
	}
	
	public static OrderStatus orderStatus(List<OrderLine> orderlines) {
		 OrderStatus orderStatus=OrderStatus.open;
		int size = orderlines.size();
		int compledCount=0;
		int CancelledCount=0;
		for(OrderLine ol:orderlines) {
			if(ol.getOrderLineStatus().equals(OrderLineStatus.cancelled)) {
				CancelledCount++;
			}
			else if(ol.getOrderLineStatus().equals(OrderLineStatus.cancelled)) {
				compledCount++;
			}
		}
		if(size==compledCount || size==CancelledCount) {
			orderStatus=OrderStatus.completed;
		}
		else {
			orderStatus=OrderStatus.open;
		}
		return orderStatus;
	}

	public Order saveOrder(List<OrderLine> orderline) {
		
		Order order = new Order();
		order.setAddress(orderline.get(0).getAddress());
		order.setOrderDate(LocalDate.now().toString());
		order.setOrderlines(orderline);
		order.setOrderStatus(orderStatus(orderline));
		order.setTotalAmount(claculateFinalAmount(orderline));
		repo.save(order);
		
		return order;
	}

	public Order getOrderById(Integer orderId) {
		Optional<Order> order = repo.findById(orderId);
		return order.get();
	}

	public Order getOrderByPincode(int pincode) {
		
		return null;
	}
}
	